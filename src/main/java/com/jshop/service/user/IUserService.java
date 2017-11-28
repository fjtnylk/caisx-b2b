package com.jshop.service.user;

import com.jshop.exception.user.UserServiceException;
import com.jshop.model.query.user.UserLoginQuery;
import com.jshop.model.vo.user.UserDtlVo;
import com.jshop.model.vo.user.UserIndexVo;
import com.jshop.model.vo.user.UserLoginVo;
import com.jshop.model.vo.user.UserProfileVo;

/**
 * Created by yanglikai on 2017/9/5.
 */
public interface IUserService {
  /**
   * 用户登录.
   *
   * @param query 用户登录参数实例
   * @return 登录成功实例
   * @throws UserServiceException 用户异常
   */
  UserLoginVo login(UserLoginQuery query) throws UserServiceException;

  /**
   * 退出.
   *
   * @param token 登录令牌
   */
  void logout(String token);

  /**
   * 加载用户基本信息.
   *
   * @param userName 用户名
   * @return 用户基本信息实例
   */
  UserProfileVo loadUserProfile(String userName);

  /**
   * 加载用户首页信息.
   *
   * @param userId 用户编号
   * @return 用户首页信息实例
   */
  UserIndexVo loadUserIndex(Long userId);

  /**
   * 加载用户详情信息.
   *
   * @param userId 用户编号
   * @return 用户详情信息实例
   */
  UserDtlVo loadUserDtl(Long userId);
}
