package com.jshop.model.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;

/**
 * Created by yanglikai on 2017/9/8.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderGoods implements Serializable {
  private String code;
  private String name;
  private String count;
  private String unit;

  private OrderGoods() {
  }

  public static OrderGoods builder() {
    return new OrderGoods();
  }

  public OrderGoods withCode(String code) {
    this.code = code;
    return this;
  }

  public OrderGoods withName(String name) {
    this.name = name;
    return this;
  }

  public OrderGoods withCount(String count) {
    this.count = count;
    return this;
  }

  public OrderGoods withUnit(String unit) {
    this.unit = unit;
    return this;
  }

  public OrderGoods build() {
    return this;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }
}
