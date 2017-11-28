package com.jshop.model.vo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Created by yanglikai on 2017/9/6.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserIndexVo {
  private String name;
  private Double dicBalance;
  private String dicCode;
  @JsonIgnore
  private String custServiceTel;

  private UserIndexVo() {
  }

  public static UserIndexVo empty() {
    return new UserIndexVo();
  }

  public static UserIndexVo builder() {
    return new UserIndexVo();
  }

  public UserIndexVo withName(String name) {
    this.name = name;
    return this;
  }

  public UserIndexVo withDicBalance(Double dicBalance) {
    this.dicBalance = dicBalance;
    return this;
  }

  public UserIndexVo withDicCode(String dicCode) {
    this.dicCode = dicCode;
    return this;
  }

  public UserIndexVo withCustServiceTel(String cutServiceTel) {
    this.custServiceTel = cutServiceTel;
    return this;
  }

  public UserIndexVo build() {
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getDicBalance() {
    return dicBalance;
  }

  public void setDicBalance(Double dicBalance) {
    this.dicBalance = dicBalance;
  }

  public String getDicCode() {
    return dicCode;
  }

  public void setDicCode(String dicCode) {
    this.dicCode = dicCode;
  }

  public String getCustServiceTel() {
    return custServiceTel;
  }

  public void setCustServiceTel(String custServiceTel) {
    this.custServiceTel = custServiceTel;
  }
}
