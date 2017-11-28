package com.jshop.model.vo.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.constant.Globals;
import com.jshop.constant.OrderStatus;
import com.jshop.model.entity.order.OrderDo;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * Created by yanglikai on 2017/9/6.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderListVo {
  private String code;
  private Integer statusCode;
  private String statusDesc;
  private int goodsCount;
  private String createTime;

  private OrderListVo() {
    this.code = "";
    this.statusCode = -1;
    this.statusDesc = "";
    this.goodsCount = 0;
    this.createTime = "";
  }

  public static OrderListVo empty() {
    return new OrderListVo();
  }

  public static OrderListVo builder() {
    return new OrderListVo();
  }

  /**
   * 订单实例→订单列表实例解析.
   *
   * @param order 订单实例
   * @return 订单列表实例
   */
  public OrderListVo parseFrom(OrderDo order) {
    this.code = order.getOrderId() == null ? "" : order.getOrderId();
    this.statusCode = order.getOrderStatus();
    this.statusDesc = OrderStatus.parseFrom(order.getOrderStatus());
    this.goodsCount = order.getOrderGoodsCount();
    this.createTime = DateFormatUtils.format(order.getAddTime(), Globals.DATE_FORMAT_yyyyMMdd);
    return this;
  }

  public OrderListVo withCode(String code) {
    this.code = code;
    return this;
  }

  public OrderListVo withStatus(Integer status) {
    this.statusCode = status;
    return this;
  }

  public OrderListVo withStatusDesc(String statusDesc) {
    this.statusDesc = statusDesc;
    return this;
  }

  public OrderListVo withGoodsCount(int goodsCount) {
    this.goodsCount = goodsCount;
    return this;
  }

  public OrderListVo withCreateTime(String createTime) {
    this.createTime = createTime;
    return this;
  }

  public OrderListVo build() {
    return this;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getGoodsCount() {
    return goodsCount;
  }

  public void setGoodsCount(int goodsCount) {
    this.goodsCount = goodsCount;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public String getStatusDesc() {
    return statusDesc;
  }

  public void setStatusDesc(String statusDesc) {
    this.statusDesc = statusDesc;
  }
}
