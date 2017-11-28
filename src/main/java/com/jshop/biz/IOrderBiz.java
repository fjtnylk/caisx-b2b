package com.jshop.biz;

import com.jshop.exception.order.OrderServiceException;
import com.jshop.model.entity.order.OrderDo;
import com.jshop.model.entity.order.OrderOriginalDo;

/**
 * Created by yanglikai on 2017/9/14.
 */
public interface IOrderBiz {

  /**
   * 订单提交.
   *
   * @param order 订单数据
   * @param orderOriginal 订单原数据
   * @return 订单编号
   * @throws OrderServiceException 订单异常
   */
  String submit(OrderDo order, OrderOriginalDo orderOriginal) throws OrderServiceException;
}
