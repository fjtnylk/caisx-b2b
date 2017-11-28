package com.jshop.repository.user;

import com.baomidou.mybatisplus.service.IService;
import com.jshop.model.entity.user.CreditCustInfoDo;

/**
 * Created by yanglikai on 2017/9/6.
 */
public interface ICreditCustInfoRepository<T> extends IService<T> {

  /**
   * 根据客户编号查询信控信息.
   *
   * @param custNo 客户编号
   * @return 信控信息实体
   */
  CreditCustInfoDo queryByCustNo(String custNo);
}
