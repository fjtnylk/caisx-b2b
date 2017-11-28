package com.jshop.model.entity.user;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jshop.model.Do;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by yanglikai on 2017/9/19.
 */
@TableName(value = "jshop_user_target_store")
public class UserTargetStoreDo extends Do {
  @TableId
  private Long id;
  @TableField
  private Long userId;
  @TableField
  private String contractStoreNo;
  @TableField
  private String targetStoreNo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserTargetStoreDo that = (UserTargetStoreDo) o;

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
}
