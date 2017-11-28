package com.jshop.repository.order;

import com.baomidou.mybatisplus.service.IService;
import com.jshop.model.entity.order.OrderOriginalDo;

/**
 * Created by yanglikai on 2017/9/13.
 */
public interface IOrderOriginalRepository<T> extends IService<T> {

  /**
   * 根据订单编号查询订单原始信息.
   *
   * @param orderId 订单编号
   * @return 订单原始信息实例
   */
  OrderOriginalDo queryById(Long orderId);

  /**
   * 添加订单原始信息.
   *
   * @param target 订单原始信息实例
   */
  void add(OrderOriginalDo target);

  /**
   * 根据订单主键编号获取订单原始商品数据.
   *
   * @param orderId 订单主键编号
   * @return 订单原始商品数据实例
   */
  OrderOriginalDo queryByOrderId(Long orderId);
}
