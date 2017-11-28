package com.jshop.model.query.order;

import com.jshop.model.Query;

/**
 * Created by yanglikai on 2017/9/13.
 */
public class OrderDtlQuery extends Query {
  private Long order_code;

  public Long getOrder_code() {
    return order_code;
  }

  public void setOrder_code(Long order_code) {
    this.order_code = order_code;
  }
}
