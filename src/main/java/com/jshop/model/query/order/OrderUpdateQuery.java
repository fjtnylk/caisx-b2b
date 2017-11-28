package com.jshop.model.query.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Query;

/**
 * Created by yanglikai on 2017/9/13.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderUpdateQuery extends Query {
  private String orderCode;

  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }
}
