package com.jshop.model.vo.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Vo;

/**
 * Created by yanglikai on 2017/9/6.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderDtlTopVo extends Vo {
  private OrderListVo orderProfile;
  private OrderExtVo orderExt;

  private OrderDtlTopVo() {
    this.orderProfile = OrderListVo.empty();
    this.orderExt = OrderExtVo.empty();
  }

  public static OrderDtlTopVo empty() {
    return new OrderDtlTopVo();
  }

  public static OrderDtlTopVo builder() {
    return new OrderDtlTopVo();
  }

  public OrderDtlTopVo withOrderProfile(OrderListVo orderProfile) {
    this.orderProfile = orderProfile;
    return this;
  }

  public OrderDtlTopVo withOrderExt(OrderExtVo orderExt) {
    this.orderExt = orderExt;
    return this;
  }

  public OrderDtlTopVo build() {
    return this;
  }

  public OrderListVo getOrderProfile() {
    return orderProfile;
  }

  public void setOrderProfile(OrderListVo orderProfile) {
    this.orderProfile = orderProfile;
  }

  public OrderExtVo getOrderExt() {
    return orderExt;
  }

  public void setOrderExt(OrderExtVo orderExt) {
    this.orderExt = orderExt;
  }
}
