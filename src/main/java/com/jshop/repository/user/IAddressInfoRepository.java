package com.jshop.repository.user;

import com.baomidou.mybatisplus.service.IService;
import com.jshop.model.entity.user.AddressInfoDo;

/**
 * Created by yanglikai on 2017/9/14.
 */
public interface IAddressInfoRepository<T> extends IService<T> {

  /**
   * 根据客户编号获取用户地址信息.
   *
   * @param custCode 客户编号
   * @return 用户地址信息实例
   */
  AddressInfoDo queryByCustCode(String custCode);
}
