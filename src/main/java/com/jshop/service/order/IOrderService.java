package com.jshop.service.order;

import com.jshop.exception.order.OrderServiceException;
import com.jshop.model.query.order.OrderCreateQuery;
import com.jshop.model.vo.order.OrderCreateVo;
import com.jshop.model.vo.order.OrderDtlVo;
import com.jshop.model.vo.order.OrderInitVo;
import com.jshop.model.vo.order.OrderListVo;
import java.util.List;

/**
 * Created by yanglikai on 2017/9/6.
 */
public interface IOrderService {

  /**
   * 加载用户最近订单信息.
   *
   * @param userName 用户名
   * @return 用户最近订单信息集合
   */
  List<OrderListVo> loadLastOrder(String userName);

  /**
   * 加载订单全部信息.
   *
   * @param userId 用户编号
   * @param page   当前页数
   * @return 全部订单信息实例
   */
  List<OrderListVo> loadList4All(Long userId, Integer page);

  /**
   * 加载待接单信息.
   *
   * @param userId 用户编号
   * @param page   当前页数
   * @return 待接单信息实例
   */
  List<OrderListVo> loadList4Receiving(Long userId, Integer page);

  /**
   * 加载配送中订单信息.
   *
   * @param userId 用户编号
   * @param page   当前页数
   * @return 配送中订单信息实例
   */
  List<OrderListVo> loadList4Delivering(Long userId, Integer page);

  /**
   * 加载订单详情.
   *
   * @param orderCode 订单编号
   * @return 订单详情实例
   */
  OrderDtlVo loadDtl(Long orderCode);

  /**
   * 取消订单.
   *
   * @param orderCode 订单编号
   */
  void cancel(String orderCode);

  /**
   * 下单页面初始化数据.
   *
   * @param userId 用户编号
   * @return 初始化数据实例
   */
  OrderInitVo init(Long userId);

  /**
   * 创建订单.
   *
   * @param query 订单数据
   * @return 订单编号
   * @throws OrderServiceException 订单异常
   */
  OrderCreateVo create(OrderCreateQuery query) throws OrderServiceException;
}
