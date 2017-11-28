package com.jshop.repository.order;

import com.baomidou.mybatisplus.service.IService;
import com.jshop.model.entity.order.OrderDo;
import java.util.List;

/**
 * Created by yanglikai on 2017/9/6.
 */
public interface IOrderRepository<T> extends IService<T> {

  /**
   * 查询用户最近订单.
   *
   * @param userName 用户名
   * @return 用户最近订单实例
   */
  OrderDo query4LastOrder(String userName);

  /**
   * 订单分页.
   *
   * @param userId 用户编号
   * @param page   当前页数
   * @param status 订单状态
   * @return 订单分页实例
   */
  List<OrderDo> queryPage(Long userId, Integer page, Integer status);

  /**
   * 根据订单编号查询订单.
   *
   * @param orderCode 订单编号
   * @return 订单信息实例
   */
  OrderDo queryByCode(String orderCode);

  /**
   * 根据主键查询订单.
   *
   * @param id 订单编号
   * @return 订单信息实例
   */
  OrderDo queryById(Long id);

  /**
   * 取消订单.
   *
   * @param orderId 订单编号
   * @return 受影响行数
   */
  int update4Cancel(String orderId);

  /**
   * 创建订单.
   *
   * @param target 订单数据
   * @return 订单数据实例
   */
  OrderDo insertOrder(OrderDo target);

  /**
   * 自增订单流水编号.
   *
   * @return 自增订单流水编号
   */
  String increment();
}
