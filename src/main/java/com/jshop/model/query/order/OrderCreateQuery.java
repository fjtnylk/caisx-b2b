package com.jshop.model.query.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.constant.Messages;
import com.jshop.model.Query;
import com.jshop.model.domain.CodeName;
import com.jshop.model.domain.OrderDeliveryAddr;
import com.jshop.model.domain.OrderGoods;
import java.util.List;
import javax.validation.constraints.Size;

/**
 * Created by yanglikai on 2017/9/8.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderCreateQuery extends Query {
  private OrderDeliveryAddr deliveryAddr;
  private OrderDeliveryDateQuery deliveryDate;
  private CodeName orderType;
  private String remark;
  @Size(min = 1, message = Messages.ORDER_CREATE_1001)
  private List<OrderGoods> goods;
  private Integer totalCount;

  public OrderDeliveryAddr getDeliveryAddr() {
    return deliveryAddr;
  }

  public void setDeliveryAddr(OrderDeliveryAddr deliveryAddr) {
    this.deliveryAddr = deliveryAddr;
  }

  public OrderDeliveryDateQuery getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(OrderDeliveryDateQuery deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public CodeName getOrderType() {
    return orderType;
  }

  public void setOrderType(CodeName orderType) {
    this.orderType = orderType;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public List<OrderGoods> getGoods() {
    return goods;
  }

  public void setGoods(List<OrderGoods> goods) {
    this.goods = goods;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }
}
