package com.jshop.biz.impl;

import com.jshop.biz.IOrderBiz;
import com.jshop.datasource.annotation.DbMsEnum;
import com.jshop.datasource.annotation.SwitchDs;
import com.jshop.exception.order.OrderServiceException;
import com.jshop.exception.order.OrderSubmitException;
import com.jshop.model.entity.order.OrderDo;
import com.jshop.model.entity.order.OrderOriginalDo;
import com.jshop.repository.order.IOrderOriginalRepository;
import com.jshop.repository.order.IOrderRepository;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yanglikai on 2017/9/14.
 */
@Service
public class OrderBizImpl implements IOrderBiz {
  @Resource
  private IOrderRepository orderRepository;
  @Resource
  private IOrderOriginalRepository orderOriginalRepository;

  /**
   * 订单提交.
   *
   * @param order         订单数据
   * @param orderOriginal 订单原数据
   * @return 订单编号
   * @throws OrderServiceException 订单异常
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
  @Override
  public String submit(OrderDo order, OrderOriginalDo orderOriginal) throws OrderSubmitException {
    OrderDo insertOrder = orderRepository.insertOrder(order);

    long orderId = insertOrder.getId();
    orderOriginalRepository.add(orderOriginal.withOrderId(orderId));
    return insertOrder.getOrderId();
  }
}
