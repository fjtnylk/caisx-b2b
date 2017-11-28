package com.jshop.model.entity.user;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jshop.constant.Globals;
import com.jshop.model.Do;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yanglikai on 2017/9/5.
 */
@TableName(value = "jshop_user")
public class UserDo extends Do {
  @TableId
  private Long id;
  @TableField(value = "userName")
  private String userName;
  @TableField
  private String password;
  @TableField
  private String mobile;
  @TableField
  private String salt;
  @TableField
  private String userContractNo;
  @TableField(value = "trueName")
  private String trueName;
  @TableField
  private String receiveTime;
  @TableField
  private String userOrderType;
  @TableField
  private Long storeId;
  @TableField
  private String contractStoreNo;
  @TableField
  private String targetStoreNo;
  @TableField(value = "userRole")
  private String userRole;
  @TableField
  private String custServiceTel;

  /**
   * 是否是子账号.
   *
   * @return true:子账号,false:非子账号
   */
  public boolean isSub() {
    return Globals.SUB_USER_ROLE.equals(userRole);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getUserContractNo() {
    return userContractNo;
  }

  public void setUserContractNo(String userContractNo) {
    this.userContractNo = userContractNo;
  }

  public String getTrueName() {
    return trueName;
  }

  public void setTrueName(String trueName) {
    this.trueName = trueName;
  }

  public String getReceiveTime() {
    return receiveTime;
  }

  public void setReceiveTime(String receiveTime) {
    this.receiveTime = receiveTime;
  }

  public String getUserOrderType() {
    return userOrderType;
  }

  public void setUserOrderType(String userOrderType) {
    this.userOrderType = userOrderType;
  }

  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }

  public String getContractStoreNo() {
    return contractStoreNo;
  }

  public void setContractStoreNo(String contractStoreNo) {
    this.contractStoreNo = contractStoreNo;
  }

  public String getTargetStoreNo() {
    return targetStoreNo;
  }

  public void setTargetStoreNo(String targetStoreNo) {
    this.targetStoreNo = targetStoreNo;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public String getCustServiceTel() {
    return custServiceTel;
  }

  public void setCustServiceTel(String custServiceTel) {
    this.custServiceTel = custServiceTel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserDo userDo = (UserDo) o;

    return new EqualsBuilder()
        .append(id, userDo.id)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(id)
        .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("userName", userName)
        .toString();
  }
}
