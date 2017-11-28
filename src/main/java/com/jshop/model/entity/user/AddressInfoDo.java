package com.jshop.model.entity.user;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jshop.model.Do;

/**
 * Created by yanglikai on 2017/9/14.
 */
@TableName(value = "jshop_address_info")
public class AddressInfoDo extends Do {
  @TableId
  private Long id;
  @TableField
  private String custCode;
  @TableField
  private String relAddr;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCustCode() {
    return custCode;
  }

  public void setCustCode(String custCode) {
    this.custCode = custCode;
  }

  public String getRelAddr() {
    return relAddr;
  }

  public void setRelAddr(String relAddr) {
    this.relAddr = relAddr;
  }
}
