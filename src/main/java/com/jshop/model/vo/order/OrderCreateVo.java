package com.jshop.model.vo.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Vo;

/**
 * Created by yanglikai on 2017/9/8.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderCreateVo extends Vo {
  private String orderCode;

  private OrderCreateVo() {
  }

  public static OrderCreateVo empty() {
    return new OrderCreateVo();
  }

  public static OrderCreateVo builder() {
    return new OrderCreateVo();
  }

  public OrderCreateVo withOrderCode(String orderCode) {
    this.orderCode = orderCode;
    return this;
  }

  public OrderCreateVo build() {
    return this;
  }

  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }
}
