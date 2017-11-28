package com.jshop.model.entity.order;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jshop.model.Do;
import com.jshop.model.domain.GoodsOriginalInfoList;
import java.util.Date;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by yanglikai on 2017/9/13.
 */
@TableName(value = "jshop_order_original")
public class OrderOriginalDo extends Do {
  @TableId
  private Long id;
  @TableField
  private Long orderId;
  @TableField
  private GoodsOriginalInfoList goodsInfo;
  @TableField
  private Date createTime;
  @TableField
  private Date updateTime;

  private OrderOriginalDo() {
    this.createTime = new Date();
    this.updateTime = new Date();
  }

  public static OrderOriginalDo builder() {
    return new OrderOriginalDo();
  }

  public OrderOriginalDo withOrderId(Long orderId) {
    this.orderId = orderId;
    return this;
  }

  public OrderOriginalDo withGoodsInfo(GoodsOriginalInfoList goodsInfo) {
    this.goodsInfo = goodsInfo;
    return this;
  }

  public OrderOriginalDo build() {
    return this;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public GoodsOriginalInfoList getGoodsInfo() {
    return goodsInfo;
  }

  public void setGoodsInfo(GoodsOriginalInfoList goodsInfo) {
    this.goodsInfo = goodsInfo;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    OrderOriginalDo that = (OrderOriginalDo) o;

    return new EqualsBuilder()
        .append(orderId, that.orderId)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(orderId)
        .toHashCode();
  }
}
