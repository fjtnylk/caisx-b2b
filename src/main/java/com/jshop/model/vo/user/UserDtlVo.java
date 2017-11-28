package com.jshop.model.vo.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Vo;

/**
 * Created by yanglikai on 2017/9/6.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDtlVo extends Vo {
  private String name;
  private String contact;
  private String contactMobile;

  private UserDtlVo() {
  }

  public static UserDtlVo empty() {
    return new UserDtlVo();
  }

  public static UserDtlVo builder() {
    return new UserDtlVo();
  }

  public UserDtlVo withName(String name) {
    this.name = name;
    return this;
  }

  public UserDtlVo withContact(String contact) {
    this.contact = contact;
    return this;
  }

  public UserDtlVo withContactMobile(String contactMobile) {
    this.contactMobile = contactMobile;
    return this;
  }

  public UserDtlVo build() {
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getContactMobile() {
    return contactMobile;
  }

  public void setContactMobile(String contactMobile) {
    this.contactMobile = contactMobile;
  }
}
