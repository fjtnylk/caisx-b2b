package com.jshop.repository.user;

import com.baomidou.mybatisplus.service.IService;
import com.jshop.model.entity.user.UserTargetStoreDo;

/**
 * Created by yanglikai on 2017/9/19.
 */
public interface IUserTargetStoreRepository<T> extends IService<T> {

  /**
   * 根据用户名获取用户签约信息.
   *
   * @param userId 用户编号
   * @return 用户签约信息实例
   */
  UserTargetStoreDo queryByUserId(Long userId);
}
