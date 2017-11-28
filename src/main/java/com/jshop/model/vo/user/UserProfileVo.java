package com.jshop.model.vo.user;

/**
 * Created by yanglikai on 2017/9/6.
 */
public class UserProfileVo {
  private Long userId;
  private String userName;
  private String mobile;
  private String userContractNo;

  public UserProfileVo withUserId(Long userId) {
    this.userId = userId;
    return this;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getUserContractNo() {
    return userContractNo;
  }

  public void setUserContractNo(String userContractNo) {
    this.userContractNo = userContractNo;
  }
}
