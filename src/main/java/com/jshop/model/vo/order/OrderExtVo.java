package com.jshop.model.vo.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Vo;

/**
 * Created by yanglikai on 2017/9/6.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderExtVo extends Vo {
  private String desc;
  private String orderTypeName;
  private Double totalAmount;
  private String remark;
  private String deliveryDate;
  private String deliveryAddr;

  private OrderExtVo() {
    this.desc = "";
    this.orderTypeName = "";
    this.totalAmount = 0.0;
    this.remark = "";
  }

  public static OrderExtVo empty() {
    return new OrderExtVo();
  }

  public static OrderExtVo builder() {
    return new OrderExtVo();
  }

  public OrderExtVo withDesc(String desc) {
    this.desc = desc;
    return this;
  }

  public OrderExtVo withOrderTypeName(String orderTypeName) {
    this.orderTypeName = orderTypeName;
    return this;
  }

  public OrderExtVo withTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

  public OrderExtVo withRemark(String remark) {
    this.remark = remark;
    return this;
  }

  public OrderExtVo withDeliveryDate(String deliveryDate) {
    this.deliveryDate = deliveryDate;
    return this;
  }

  public OrderExtVo withDeliveryAddr(String deliveryAddr) {
    this.deliveryAddr = deliveryAddr;
    return this;
  }

  public OrderExtVo build() {
    return this;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getOrderTypeName() {
    return orderTypeName;
  }

  public void setOrderTypeName(String orderTypeName) {
    this.orderTypeName = orderTypeName;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(String deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public String getDeliveryAddr() {
    return deliveryAddr;
  }

  public void setDeliveryAddr(String deliveryAddr) {
    this.deliveryAddr = deliveryAddr;
  }
}
