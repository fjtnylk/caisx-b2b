package com.jshop.repository.user;

import com.baomidou.mybatisplus.service.IService;
import com.jshop.model.entity.user.BaseCustInfoDo;

/**
 * Created by yanglikai on 2017/9/6.
 */
public interface IBaseCustInfoRepository<T> extends IService<T> {

  /**
   * 根据客户编号查询客户基本信息.
   *
   * @param custNo 客户编号
   * @return 客户基本信息实体
   */
  BaseCustInfoDo queryByCustNo(String custNo);
}
