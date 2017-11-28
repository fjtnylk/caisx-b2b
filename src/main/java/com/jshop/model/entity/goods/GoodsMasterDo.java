package com.jshop.model.entity.goods;

import com.baomidou.mybatisplus.annotations.TableName;
import com.jshop.model.Do;

/**
 * Created by yanglikai on 2017/9/15.
 */
@TableName(value = "jshop_csx_goods_info")
public class GoodsMasterDo extends Do {
  private Long id;
  private String dcid;
  private String goodCode;
  private String barcode;
  private String mrp;
  private String goodName;
  private String spec;
  private String shelfLife;
  private String brandId;
  private String sortId;
  private String unit;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDcid() {
    return dcid;
  }

  public void setDcid(String dcid) {
    this.dcid = dcid;
  }

  public String getGoodCode() {
    return goodCode;
  }

  public void setGoodCode(String goodCode) {
    this.goodCode = goodCode;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public String getMrp() {
    return mrp;
  }

  public void setMrp(String mrp) {
    this.mrp = mrp;
  }

  public String getGoodName() {
    return goodName;
  }

  public void setGoodName(String goodName) {
    this.goodName = goodName;
  }

  public String getSpec() {
    return spec;
  }

  public void setSpec(String spec) {
    this.spec = spec;
  }

  public String getShelfLife() {
    return shelfLife;
  }

  public void setShelfLife(String shelfLife) {
    this.shelfLife = shelfLife;
  }

  public String getBrandId() {
    return brandId;
  }

  public void setBrandId(String brandId) {
    this.brandId = brandId;
  }

  public String getSortId() {
    return sortId;
  }

  public void setSortId(String sortId) {
    this.sortId = sortId;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }
}
