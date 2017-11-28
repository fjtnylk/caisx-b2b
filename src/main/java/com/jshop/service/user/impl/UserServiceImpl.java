package com.jshop.service.user.impl;

import com.jshop.api.context.UserContext;
import com.jshop.constant.RedisKey;
import com.jshop.exception.user.UserLoginException;
import com.jshop.exception.user.UserServiceException;
import com.jshop.model.ModelParser;
import com.jshop.model.entity.user.BaseCustInfoDo;
import com.jshop.model.entity.user.CreditCustInfoDo;
import com.jshop.model.entity.user.UserDo;
import com.jshop.model.query.user.UserLoginQuery;
import com.jshop.model.vo.user.UserDtlVo;
import com.jshop.model.vo.user.UserIndexVo;
import com.jshop.model.vo.user.UserLoginVo;
import com.jshop.model.vo.user.UserProfileVo;
import com.jshop.repository.user.IBaseCustInfoRepository;
import com.jshop.repository.user.ICreditCustInfoRepository;
import com.jshop.repository.user.IUserRepository;
import com.jshop.service.user.IUserService;
import com.jshop.utils.JwtUtils;
import javax.annotation.Resource;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Service
public class UserServiceImpl implements IUserService {
  @Resource
  private IUserRepository userRepository;
  @Resource
  private ICreditCustInfoRepository creditCustInfoRepository;
  @Resource
  private IBaseCustInfoRepository baseCustInfoRepository;
  @Resource
  private HashedCredentialsMatcher hashedCredentialsMatcher;
  @Resource
  private StringRedisTemplate springRedisClient;

  /**
   * 用户登录.
   *
   * @param query 用户登录参数实例
   * @return 登录成功实例
   * @throws UserServiceException 用户异常
   */
  @Override
  public UserLoginVo login(UserLoginQuery query) throws UserServiceException {
    // 1.用户名有效性效验
    String userName = query.getUserName();
    UserDo userDo = userRepository.queryUser(userName);
    if (userDo == null) {
      throw new UserLoginException();
    }
    // 2.密码有效性验证
    String original = query.getPassword();
    String password = encryptPassword(original, userDo.getSalt());
    if (password.equals(userDo.getPassword()) == false) {
      throw new UserLoginException();
    }
    // 3.创建token
    String token = JwtUtils.createToken(userName);
    // 4.缓存token
    cacheToken(userName, token);
    return UserLoginVo.builder()
        .withUserName(userName)
        .withToken(token)
        .build();
  }

  /**
   * 退出.
   *
   * @param token 登录令牌
   */
  @Override
  public void logout(String token) {
    String key = String.format(RedisKey.B2B_USER_TOKEN.key, UserContext.getUserName());
    String value = springRedisClient.opsForValue().get(key);
    if (StringUtils.isEmpty(value)) {
      return;
    }

    springRedisClient.opsForValue().getOperations().delete(key);
  }

  /**
   * 加载用户基本信息.
   *
   * @param userName 用户名
   * @return 用户基本信息实例
   */
  @Override
  public UserProfileVo loadUserProfile(String userName) {
    UserDo user = userRepository.queryUser(userName);
    UserProfileVo target = ModelParser.parse(user, UserProfileVo.class);

    return target
        .withUserId(user.getId());
  }

  /**
   * 加载用户首页信息.
   *
   * @param userId 用户编号
   * @return 用户首页信息实例
   */
  @Override
  public UserIndexVo loadUserIndex(Long userId) {
    // 1.用户信息
    UserDo user = userRepository.queryUser(userId);
    if (user == null) {
      return UserIndexVo.empty();
    }
    // 2.客户信控信息
    CreditCustInfoDo creditCustInfo =
        creditCustInfoRepository.queryByCustNo(
            user.isSub()
                ? user.getContractStoreNo()
                : user.getUserContractNo());
    if (creditCustInfo == null) {
      return UserIndexVo.empty();
    }
    // 3.客户基本信息
    BaseCustInfoDo baseCustInfoDo =
        baseCustInfoRepository.queryByCustNo(
            user.isSub()
                ? user.getContractStoreNo()
                : creditCustInfo.getCustNo());
    if (baseCustInfoDo == null) {
      return UserIndexVo.empty();
    }

    return UserIndexVo.builder()
        .withName(baseCustInfoDo.getCustName())
        .withDicBalance(creditCustInfo.getAvailableCredit())
        .withDicCode(creditCustInfo.getCustNo())
        .withCustServiceTel(user.getCustServiceTel())
        .build();
  }

  /**
   * 加载用户详情信息.
   *
   * @param userId 用户编号
   * @return 用户详情信息实例
   */
  @Override
  public UserDtlVo loadUserDtl(Long userId) {
    // 1.用户信息
    UserDo user = userRepository.queryUser(userId);
    if (user == null) {
      return UserDtlVo.empty();
    }
    // 2.客户信息
    BaseCustInfoDo baseCustInfo = baseCustInfoRepository.queryByCustNo(
        user.isSub()
            ? user.getContractStoreNo()
            : user.getUserContractNo());
    if (baseCustInfo == null) {
      return UserDtlVo.empty();
    }

    return UserDtlVo.builder()
        .withName(baseCustInfo.getCustName())
        .withContact(baseCustInfo.getCustCon())
        .withContactMobile(baseCustInfo.getConTel())
        .build();
  }

  /**
   * 加密.
   *
   * @param password 密码
   * @param salt     盐
   * @return 加密后密码
   */
  private String encryptPassword(String password, String salt) {
    int hashIterations = hashedCredentialsMatcher.getHashIterations();
    String hashAlgorithmName = hashedCredentialsMatcher.getHashAlgorithmName();
    return new SimpleHash(hashAlgorithmName, password, ByteSource.Util.bytes(salt), hashIterations)
        .toHex();
  }

  /**
   * 缓存token.
   *
   * @param userName userName
   * @param token    token
   */
  private void cacheToken(String userName, String token) {
    String key = String.format(RedisKey.B2B_USER_TOKEN.key, userName);
    springRedisClient.opsForValue().set(key, token);
  }
}
