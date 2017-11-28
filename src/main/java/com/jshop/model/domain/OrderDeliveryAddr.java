package com.jshop.model.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;

/**
 * Created by yanglikai on 2017/9/8.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderDeliveryAddr implements Serializable {
  private String city;
  private String district;
  private String prov;
  private String street;

  private OrderDeliveryAddr() {
  }

  public static OrderDeliveryAddr builder() {
    return new OrderDeliveryAddr();
  }

  public OrderDeliveryAddr withCity(String city) {
    this.city = city;
    return this;
  }

  public OrderDeliveryAddr withDistrict(String district) {
    this.district = district;
    return this;
  }

  public OrderDeliveryAddr withProv(String prov) {
    this.prov = prov;
    return this;
  }

  public OrderDeliveryAddr withStreet(String street) {
    this.street = street;
    return this;
  }

  public OrderDeliveryAddr build() {
    return this;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getProv() {
    return prov;
  }

  public void setProv(String prov) {
    this.prov = prov;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(prov).append(city).append(district).append(street);
    return sb.toString();
  }
}
