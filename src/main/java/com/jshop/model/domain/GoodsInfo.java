package com.jshop.model.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by yanglikai on 2017/9/6.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GoodsInfo implements Serializable {
  private Long id;
  private String goods_code;
  private String goods_name;
  private BigDecimal sale_price;
  private BigDecimal common_price;
  private String goods_count;
  private String barcode;
  private String customerize_unit;
  private String customerize_unit_name;
  private String old_unit;
  private BigDecimal goods_all_price;
  private String confirm_count;
  private String out_count;
  private String sap_category_no;

  private GoodsInfo() {
  }

  public static GoodsInfo empty() {
    return new GoodsInfo();
  }

  public static GoodsInfo builder() {
    return new GoodsInfo();
  }

  public GoodsInfo withId(Long id) {
    this.id = id;
    return this;
  }

  public GoodsInfo withGoodsCode(String goodsCode) {
    this.goods_code = goodsCode;
    return this;
  }

  public GoodsInfo withGoodsName(String goodsName) {
    this.goods_name = goodsName;
    return this;
  }

  public GoodsInfo withGoodsCount(String goodsCount) {
    this.goods_count = goodsCount;
    return this;
  }

  public GoodsInfo withOrderUnit(String unit) {
    this.customerize_unit_name = unit;
    return this;
  }

  public GoodsInfo withGoodsUnit(String unit) {
    this.old_unit = unit;
    return this;
  }

  public GoodsInfo withBarCode(String barCode) {
    this.barcode = barCode;
    return this;
  }

  public GoodsInfo withSapCategoryNo(String sapCategoryNo) {
    this.sap_category_no = sapCategoryNo;
    return this;
  }

  public GoodsInfo withOriginalPrice(BigDecimal originalPrice) {
    this.common_price = originalPrice;
    return this;
  }

  public GoodsInfo withSalePrice(BigDecimal salePrice) {
    this.sale_price = salePrice;
    return this;
  }

  public GoodsInfo withConfirmCount(String confirmCount) {
    this.confirm_count = confirmCount;
    return this;
  }

  public GoodsInfo build() {
    return this;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGoods_code() {
    return goods_code;
  }

  public void setGoods_code(String goods_code) {
    this.goods_code = goods_code;
  }

  public String getGoods_name() {
    return goods_name;
  }

  public void setGoods_name(String goods_name) {
    this.goods_name = goods_name;
  }

  public String getGoods_count() {
    return goods_count;
  }

  public void setGoods_count(String goods_count) {
    this.goods_count = goods_count;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getCustomerize_unit() {
    return customerize_unit;
  }

  public void setCustomerize_unit(String customerize_unit) {
    this.customerize_unit = customerize_unit;
  }

  public String getCustomerize_unit_name() {
    return customerize_unit_name;
  }

  public void setCustomerize_unit_name(String customerize_unit_name) {
    this.customerize_unit_name = customerize_unit_name;
  }

  public String getOld_unit() {
    return old_unit;
  }

  public void setOld_unit(String old_unit) {
    this.old_unit = old_unit;
  }

  public String getConfirm_count() {
    return confirm_count;
  }

  public void setConfirm_count(String confirm_count) {
    this.confirm_count = confirm_count;
  }

  public String getOut_count() {
    return out_count;
  }

  public void setOut_count(String out_count) {
    this.out_count = out_count;
  }

  public String getSap_category_no() {
    return sap_category_no;
  }

  public void setSap_category_no(String sap_category_no) {
    this.sap_category_no = sap_category_no;
  }

  public BigDecimal getSale_price() {
    return sale_price;
  }

  public void setSale_price(BigDecimal sale_price) {
    this.sale_price = sale_price;
  }

  public BigDecimal getCommon_price() {
    return common_price;
  }

  public void setCommon_price(BigDecimal common_price) {
    this.common_price = common_price;
  }

  public BigDecimal getGoods_all_price() {
    return goods_all_price;
  }

  public void setGoods_all_price(BigDecimal goods_all_price) {
    this.goods_all_price = goods_all_price;
  }
}
