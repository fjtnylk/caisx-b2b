package com.jshop.api.controller.order;

import com.jshop.api.ApiResult;
import com.jshop.api.context.UserContext;
import com.jshop.constant.Globals;
import com.jshop.constant.OrderStatus;
import com.jshop.exception.order.OrderServiceException;
import com.jshop.model.query.order.OrderCreateQuery;
import com.jshop.model.query.order.OrderDtlQuery;
import com.jshop.model.query.order.OrderListQuery;
import com.jshop.model.query.order.OrderUpdateQuery;
import com.jshop.service.order.IOrderService;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2017/9/7.
 */
@RequestMapping(value = "/api")
@RestController
public class OrderController {
  @Resource
  private IOrderService orderService;

  /**
   * 订单列表.
   *
   * @param query 订单列表加载参数
   * @return 订单列表实例
   */
  @RequestMapping(
      value = "/caisx.order.list/" + Globals.API_VERSION + "/search",
      method = RequestMethod.GET)
  @ResponseBody
  public ApiResult list(OrderListQuery query) {
    long userId = UserContext.getUserId();
    int status = query.getStatus();
    int page = query.getPage();

    if (OrderStatus.ALL.code() == status) {
      // 全部
      return ApiResult.success(orderService.loadList4All(userId, page));
    } else if (OrderStatus.RECEIVING_10.code() == status) {
      // 待接单
      return ApiResult.success(orderService.loadList4Receiving(userId, page));
    } else if (OrderStatus.DELIVERING_20.code() == status) {
      // 配送中
      return ApiResult.success(orderService.loadList4Delivering(userId, page));
    } else {
      throw new UnsupportedOperationException(String.format("暂不支持的状态类型-[%s]", status));
    }
  }

  /**
   * 订单详情.
   *
   * @param query 订单详情参数实例
   * @return 订单详情实例
   */
  @RequestMapping(
      value = "/caisx.order.dtl/" + Globals.API_VERSION + "/get",
      method = RequestMethod.GET)
  @ResponseBody
  public ApiResult dtl(OrderDtlQuery query) {
    return ApiResult.success(orderService.loadDtl(query.getOrder_code()));
  }

  /**
   * 订单取消.
   *
   * @param query 订单更新参数实例
   * @return 接口返回结果
   */
  @RequestMapping(
      value = "/caisx.order.cancel/" + Globals.API_VERSION + "/update",
      method = RequestMethod.PUT)
  @ResponseBody
  public ApiResult cancel(@RequestBody OrderUpdateQuery query) {
    orderService.cancel(query.getOrderCode());
    return ApiResult.success();
  }

  /**
   * 提交订单页面初始化.
   *
   * @return 接口返回结果
   */
  @RequestMapping(
      value = "/caisx.order.submit/" + Globals.API_VERSION + "/init",
      method = RequestMethod.GET)
  @ResponseBody
  public ApiResult init() {
    long userId = UserContext.getUserId();
    return ApiResult.success(orderService.init(userId));
  }

  /**
   * 创建订单.
   *
   * @param query 创建订单参数
   * @return 接口返回结果
   * @throws OrderServiceException 订单异常
   */
  @RequestMapping(
      value = "/caisx.order.submit/" + Globals.API_VERSION + "/create",
      method = RequestMethod.POST)
  @ResponseBody
  public ApiResult create(
      @RequestBody @Validated OrderCreateQuery query)
      throws OrderServiceException {
    return ApiResult.success(orderService.create(query));
  }
}
