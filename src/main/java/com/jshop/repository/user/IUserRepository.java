package com.jshop.repository.user;

import com.baomidou.mybatisplus.service.IService;
import com.jshop.model.entity.user.UserDo;

/**
 * Created by yanglikai on 2017/9/5.
 */
public interface IUserRepository<T> extends IService<T> {
  /**
   * 根据用户名查询用户信息.
   *
   * @param userName userName
   * @return 用户信息实例
   */
  UserDo queryUser(String userName);

  /**
   * 根据用户编号查询用户信息.
   *
   * @param userId 用户编号
   * @return 用户信息实例
   */
  UserDo queryUser(Long userId);
}
