package com.jshop.model.domain;

import java.io.Serializable;

/**
 * Created by yanglikai on 2017/9/7.
 */
public class GoodsRefundInfo implements Serializable {
  private String returnGoodsCount;
  private String returnGoodsCode;
  private String operaUserName;
  private Long returnGoodsId;
  private Double returnGoodsPrice;

  private GoodsRefundInfo() {
  }

  public static GoodsRefundInfo empty() {
    return new GoodsRefundInfo();
  }

  public String getReturnGoodsCount() {
    return returnGoodsCount;
  }

  public void setReturnGoodsCount(String returnGoodsCount) {
    this.returnGoodsCount = returnGoodsCount;
  }

  public String getReturnGoodsCode() {
    return returnGoodsCode;
  }

  public void setReturnGoodsCode(String returnGoodsCode) {
    this.returnGoodsCode = returnGoodsCode;
  }

  public String getOperaUserName() {
    return operaUserName;
  }

  public void setOperaUserName(String operaUserName) {
    this.operaUserName = operaUserName;
  }

  public Long getReturnGoodsId() {
    return returnGoodsId;
  }

  public void setReturnGoodsId(Long returnGoodsId) {
    this.returnGoodsId = returnGoodsId;
  }

  public Double getReturnGoodsPrice() {
    return returnGoodsPrice;
  }

  public void setReturnGoodsPrice(Double returnGoodsPrice) {
    this.returnGoodsPrice = returnGoodsPrice;
  }
}
