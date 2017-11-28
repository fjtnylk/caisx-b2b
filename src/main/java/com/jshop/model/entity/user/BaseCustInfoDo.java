package com.jshop.model.entity.user;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jshop.model.Do;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yanglikai on 2017/9/6.
 */
@TableName(value = "jshop_base_cust_info")
public class BaseCustInfoDo extends Do {
  @TableId
  private Long id;
  @TableField
  private String custCode;
  @TableField
  private String custName;
  @TableField
  private String custCon;
  @TableField
  private String conTel;

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

  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public String getCustCon() {
    return custCon;
  }

  public void setCustCon(String custCon) {
    this.custCon = custCon;
  }

  public String getConTel() {
    return conTel;
  }

  public void setConTel(String conTel) {
    this.conTel = conTel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    BaseCustInfoDo that = (BaseCustInfoDo) o;

    return new EqualsBuilder()
        .append(id, that.id)
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
        .append("custCode", custCode)
        .append("custName", custName)
        .toString();
  }
}
