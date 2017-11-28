package com.jshop.model.vo.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Vo;
import com.jshop.model.vo.goods.GoodsDtlVo;

/**
 * Created by yanglikai on 2017/9/6.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderDtlVo extends Vo {
  private OrderDtlTopVo top;
  private GoodsDtlVo goodsDtl;

  private OrderDtlVo() {
    this.top = OrderDtlTopVo.empty();
    this.goodsDtl = GoodsDtlVo.empty();
  }

  public static OrderDtlVo builder() {
    return new OrderDtlVo();
  }

  public static OrderDtlVo empty() {
    return new OrderDtlVo();
  }

  public OrderDtlVo withTop(OrderDtlTopVo top) {
    this.top = top;
    return this;
  }

  public OrderDtlVo withGoodsDtl(GoodsDtlVo goodsDtl) {
    this.goodsDtl = goodsDtl;
    return this;
  }

  public OrderDtlVo build() {
    return this;
  }

  public OrderDtlTopVo getTop() {
    return top;
  }

  public void setTop(OrderDtlTopVo top) {
    this.top = top;
  }

  public GoodsDtlVo getGoodsDtl() {
    return goodsDtl;
  }

  public void setGoodsDtl(GoodsDtlVo goodsDtl) {
    this.goodsDtl = goodsDtl;
  }
}
