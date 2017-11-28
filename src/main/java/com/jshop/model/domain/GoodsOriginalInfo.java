package com.jshop.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yanglikai on 2017/9/13.
 */
public class GoodsOriginalInfo implements Serializable {
  private String code;
  private String barcode;
  private String name;
  private String goodsUnit;
  private String orderUnit;
  private BigDecimal originalPrice;
  private BigDecimal salePrice;
  private String count;
  private String smallCategoryCode;

  private GoodsOriginalInfo() {
  }

  public static GoodsOriginalInfo builder() {
    return new GoodsOriginalInfo();
  }

  public GoodsOriginalInfo withCode(String code) {
    this.code = code;
    return this;
  }

  public GoodsOriginalInfo withBarcode(String barcode) {
    this.barcode = barcode;
    return this;
  }

  public GoodsOriginalInfo withName(String name) {
    this.name = name;
    return this;
  }

  public GoodsOriginalInfo withGoodsUnit(String unit) {
    this.goodsUnit = unit;
    return this;
  }

  public GoodsOriginalInfo withOrderUnit(String unit) {
    this.orderUnit = unit;
    return this;
  }

  public GoodsOriginalInfo withOriginalPrice(BigDecimal originalPrice) {
    this.originalPrice = originalPrice;
    return this;
  }

  public GoodsOriginalInfo withSalePrice(BigDecimal salePrice) {
    this.salePrice = salePrice;
    return this;
  }

  public GoodsOriginalInfo withCount(String count) {
    this.count = count;
    return this;
  }

  public GoodsOriginalInfo withSmallCategoryCode(String smallCategoryCode) {
    this.smallCategoryCode = smallCategoryCode;
    return this;
  }

  public GoodsOriginalInfo build() {
    return this;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGoodsUnit() {
    return goodsUnit;
  }

  public void setGoodsUnit(String goodsUnit) {
    this.goodsUnit = goodsUnit;
  }

  public String getOrderUnit() {
    return orderUnit;
  }

  public void setOrderUnit(String orderUnit) {
    this.orderUnit = orderUnit;
  }

  public BigDecimal getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(BigDecimal originalPrice) {
    this.originalPrice = originalPrice;
  }

  public BigDecimal getSalePrice() {
    return salePrice;
  }

  public void setSalePrice(BigDecimal salePrice) {
    this.salePrice = salePrice;
  }

  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public String getSmallCategoryCode() {
    return smallCategoryCode;
  }

  public void setSmallCategoryCode(String smallCategoryCode) {
    this.smallCategoryCode = smallCategoryCode;
  }
}
