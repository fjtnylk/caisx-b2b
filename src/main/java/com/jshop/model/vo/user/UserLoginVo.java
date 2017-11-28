package com.jshop.model.vo.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Vo;

/**
 * Created by yanglikai on 2017/9/6.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserLoginVo extends Vo {
  private String userName;
  private String token;

  public UserLoginVo() {
  }

  public static UserLoginVo builder() {
    return new UserLoginVo();
  }

  public UserLoginVo withUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public UserLoginVo withToken(String token) {
    this.token = token;
    return this;
  }

  public UserLoginVo build() {
    return this;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
