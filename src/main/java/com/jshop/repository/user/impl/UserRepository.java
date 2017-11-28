package com.jshop.repository.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jshop.datasource.annotation.DbMsEnum;
import com.jshop.datasource.annotation.SwitchDs;
import com.jshop.mapper.user.UserMapper;
import com.jshop.model.builder.EntityWrapperBuilder;
import com.jshop.model.entity.user.UserDo;
import com.jshop.repository.user.IUserRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Repository
public class UserRepository
    extends ServiceImpl<UserMapper, UserDo>
    implements IUserRepository<UserDo> {
  /**
   * 根据用户名密码查询用户信息.
   *
   * @param userName userName
   * @return 用户信息实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_USER)
  @Override
  public UserDo queryUser(String userName) {
    return super.selectOne(
        EntityWrapperBuilder
            .builder(UserDo.class)
            .where("user_contract_no={0}", userName)
            .getTarget());
  }

  /**
   * 根据用户编号查询用户信息.
   *
   * @param userId 用户编号
   * @return 用户信息实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_USER)
  @Override
  public UserDo queryUser(Long userId) {
    return super.selectOne(
        EntityWrapperBuilder
            .builder(UserDo.class)
            .where("id={0}", userId.toString())
            .getTarget());
  }
}
