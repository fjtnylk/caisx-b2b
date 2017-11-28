package com.jshop.model.vo.goods;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Vo;

/**
 * Created by yanglikai on 2017/9/7.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GoodsInfoVo extends Vo {
  private String name;
  private String buyCount;
  private String confirmCount;
  private String outCount;
  private String refundCount;

  private GoodsInfoVo() {
  }

  public static GoodsInfoVo builder() {
    return new GoodsInfoVo();
  }

  public GoodsInfoVo withName(String name) {
    this.name = name;
    return this;
  }

  public GoodsInfoVo withBuyCount(String buyCount) {
    this.buyCount = buyCount;
    return this;
  }

  public GoodsInfoVo withConfirmCount(String confirmCount) {
    this.confirmCount = confirmCount == null ? "0" : confirmCount;
    return this;
  }

  public GoodsInfoVo withOutCount(String outCount) {
    this.outCount = outCount == null ? "0" : outCount;
    return this;
  }

  public GoodsInfoVo withRefundCount(String refundCount) {
    this.refundCount = refundCount;
    return this;
  }

  public GoodsInfoVo build() {
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBuyCount() {
    return buyCount;
  }

  public void setBuyCount(String buyCount) {
    this.buyCount = buyCount;
  }

  public String getConfirmCount() {
    return confirmCount;
  }

  public void setConfirmCount(String confirmCount) {
    this.confirmCount = confirmCount;
  }

  public String getOutCount() {
    return outCount;
  }

  public void setOutCount(String outCount) {
    this.outCount = outCount;
  }

  public String getRefundCount() {
    return refundCount;
  }

  public void setRefundCount(String refundCount) {
    this.refundCount = refundCount;
  }
}
