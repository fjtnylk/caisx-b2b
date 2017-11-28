package com.jshop.model.vo.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Vo;
import com.jshop.model.domain.CodeName;
import com.jshop.model.domain.OrderDeliveryAddr;
import com.jshop.model.domain.OrderDeliveryDate;
import java.util.List;

/**
 * Created by yanglikai on 2017/9/8.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderInitVo extends Vo {
  private OrderDeliveryAddr deliveryAddr;
  private OrderDeliveryDate deliveryDate;
  private List<CodeName> orderType;

  private OrderInitVo() {
  }

  public static OrderInitVo builder() {
    return new OrderInitVo();
  }

  public static OrderInitVo empty() {
    return new OrderInitVo();
  }

  public OrderInitVo withDeliveryAddr(OrderDeliveryAddr addr) {
    this.deliveryAddr = addr;
    return this;
  }

  public OrderInitVo withDeliveryDate(OrderDeliveryDate dateVoList) {
    this.deliveryDate = dateVoList;
    return this;
  }

  public OrderInitVo withOrderType(List<CodeName> orderType) {
    this.orderType = orderType;
    return this;
  }

  public OrderInitVo build() {
    return this;
  }


  public OrderDeliveryAddr getDeliveryAddr() {
    return deliveryAddr;
  }

  public void setDeliveryAddr(OrderDeliveryAddr deliveryAddr) {
    this.deliveryAddr = deliveryAddr;
  }

  public OrderDeliveryDate getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(OrderDeliveryDate deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public List<CodeName> getOrderType() {
    return orderType;
  }

  public void setOrderType(List<CodeName> orderType) {
    this.orderType = orderType;
  }
}
