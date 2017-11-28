package com.jshop.model.entity.order;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jshop.model.Do;
import com.jshop.model.domain.GoodsInfoList;
import com.jshop.model.domain.GoodsRefundInfoList;
import com.jshop.model.domain.OrderDeliveryAddr;
import com.jshop.model.query.order.OrderDeliveryDateQuery;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yanglikai on 2017/9/6.
 */
@TableName(value = "jshop_orderform")
public class OrderDo extends Do {
  @TableId
  private Long id;
  @TableField
  private Long userId;
  @TableField
  private String userName;
  @TableField
  private Integer orderStatus;
  @TableField
  private GoodsInfoList goodsInfo;
  @TableField
  private Integer orderGoodsCount;
  @TableField(value = "totalPrice")
  private BigDecimal totalPrice;
  @TableField(value = "addTime")
  private Date addTime;
  @TableField
  private GoodsRefundInfoList returnGoodsInfo;
  @TableField
  private String receiverName;
  @TableField
  private String receiverArea;
  @TableField
  private String receiverAreaInfo;
  @TableField
  private String receiverMobile;
  @TableField
  private String deliveryTime;
  @TableField
  private String userOrderType;
  @TableField
  private String msg;
  @TableField
  private String userContractNo;
  @TableField
  private Integer orderMain;
  @TableField
  private Integer bussinessType;
  @TableField
  private Long evaUserId;
  @TableField
  private String orderId;
  @TableField
  private String orderType;
  @TableField
  private String contractStoreNo;
  @TableField
  private String targetStoreNo;
  @TableField
  private String childOrderDetail;
  @TableField
  private Long parentId;

  public OrderDo() {
  }

  public static OrderDo builder() {
    return new OrderDo();
  }

  public OrderDo withUserId(Long userId) {
    this.userId = userId;
    return this;
  }

  public OrderDo withUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public OrderDo withStatus(Integer status) {
    this.orderStatus = status;
    return this;
  }

  public OrderDo withGoodsInfo(GoodsInfoList goodsInfo) {
    this.goodsInfo = goodsInfo;
    return this;
  }

  public OrderDo withTotalCount(Integer totalCount) {
    this.orderGoodsCount = totalCount;
    return this;
  }

  public OrderDo withTotalAmount(BigDecimal totalAmount) {
    this.totalPrice = totalAmount;
    return this;
  }

  public OrderDo withCreateTime(Date createTime) {
    this.addTime = (Date) createTime.clone();
    return this;
  }

  public OrderDo withCnee(String cnee) {
    this.receiverName = cnee;
    return this;
  }

  public OrderDo withOrderType(String orderType) {
    this.userOrderType = orderType;
    return this;
  }

  public OrderDo withCustNo(String custNo) {
    this.userContractNo = custNo;
    return this;
  }

  public OrderDo withOrderMain(Integer orderMain) {
    this.orderMain = orderMain;
    return this;
  }

  public OrderDo withBizType(Integer bussinessType) {
    this.bussinessType = bussinessType;
    return this;
  }

  /**
   * 配送地址.
   *
   * @param addr 配送地址实例
   * @return 订单实例
   */
  public OrderDo withDeliveryAddr(OrderDeliveryAddr addr) {
    this.receiverArea = addr.getProv() + addr.getCity() + addr.getDistrict();
    this.receiverAreaInfo = addr.toString();
    return this;
  }

  public OrderDo withDeliveryDate(OrderDeliveryDateQuery date) {
    this.deliveryTime = date.toString();
    return this;
  }

  public OrderDo withMobile(String mobile) {
    this.receiverMobile = mobile;
    return this;
  }

  public OrderDo withRemark(String remark) {
    this.msg = remark;
    return this;
  }

  public OrderDo withFactoryId(Long factoryId) {
    this.evaUserId = factoryId;
    return this;
  }

  public OrderDo withChannel(String channel) {
    this.orderType = channel;
    return this;
  }

  public OrderDo withOrderCode(String orderCode) {
    this.orderId = orderCode;
    return this;
  }

  public OrderDo withContractStoreNo(String contractStoreNo) {
    this.contractStoreNo = contractStoreNo;
    return this;
  }

  public OrderDo withTargetStoreNo(String targetStoreNo) {
    this.targetStoreNo = targetStoreNo;
    return this;
  }

  public OrderDo build() {
    return this;
  }

  /**
   * 是否存在子订单.
   *
   * @return true:存在,false:不存在
   */
  public boolean hasSubOrder() {
    return StringUtils.isEmpty(this.childOrderDetail)
        ? false : "1".equals(this.childOrderDetail)
        ? true : false;
  }

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

  public Integer getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(Integer orderStatus) {
    this.orderStatus = orderStatus;
  }

  public GoodsInfoList getGoodsInfo() {
    return goodsInfo == null ? GoodsInfoList.empty() : goodsInfo;
  }

  public void setGoodsInfo(GoodsInfoList goodsInfo) {
    this.goodsInfo = goodsInfo;
  }

  public Integer getOrderGoodsCount() {
    return orderGoodsCount;
  }

  public void setOrderGoodsCount(Integer orderGoodsCount) {
    this.orderGoodsCount = orderGoodsCount;
  }

  public BigDecimal getTotalPrice() {
    return totalPrice == null ? BigDecimal.ZERO : totalPrice;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Date getAddTime() {
    return (Date) addTime.clone();
  }

  public void setAddTime(Date addTime) {
    this.addTime = (Date) addTime.clone();
  }

  public GoodsRefundInfoList getReturnGoodsInfo() {
    return returnGoodsInfo == null ? GoodsRefundInfoList.empty() : returnGoodsInfo;
  }

  public void setReturnGoodsInfo(GoodsRefundInfoList returnGoodsInfo) {
    this.returnGoodsInfo = returnGoodsInfo;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getReceiverName() {
    return receiverName;
  }

  public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
  }

  public String getReceiverArea() {
    return receiverArea;
  }

  public void setReceiverArea(String receiverArea) {
    this.receiverArea = receiverArea;
  }

  public String getReceiverAreaInfo() {
    return receiverAreaInfo;
  }

  public void setReceiverAreaInfo(String receiverAreaInfo) {
    this.receiverAreaInfo = receiverAreaInfo;
  }

  public String getReceiverMobile() {
    return receiverMobile;
  }

  public void setReceiverMobile(String receiverMobile) {
    this.receiverMobile = receiverMobile;
  }

  public String getDeliveryTime() {
    return deliveryTime;
  }

  public void setDeliveryTime(String deliveryTime) {
    this.deliveryTime = deliveryTime;
  }

  public String getUserOrderType() {
    return userOrderType;
  }

  public void setUserOrderType(String userOrderType) {
    this.userOrderType = userOrderType;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getUserContractNo() {
    return userContractNo;
  }

  public void setUserContractNo(String userContractNo) {
    this.userContractNo = userContractNo;
  }

  public Integer getOrderMain() {
    return orderMain;
  }

  public void setOrderMain(Integer orderMain) {
    this.orderMain = orderMain;
  }

  public Integer getBussinessType() {
    return bussinessType;
  }

  public void setBussinessType(Integer bussinessType) {
    this.bussinessType = bussinessType;
  }

  public Long getEvaUserId() {
    return evaUserId;
  }

  public void setEvaUserId(Long evaUserId) {
    this.evaUserId = evaUserId;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
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

  public String getChildOrderDetail() {
    return childOrderDetail;
  }

  public void setChildOrderDetail(String childOrderDetail) {
    this.childOrderDetail = childOrderDetail;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    OrderDo orderDo = (OrderDo) o;

    return new EqualsBuilder()
        .append(id, orderDo.id)
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
        .append("userId", userId)
        .append("orderStatus", orderStatus)
        .append("goodsInfo", goodsInfo)
        .append("orderGoodsCount", orderGoodsCount)
        .append("totalPrice", totalPrice)
        .append("addTime", addTime)
        .toString();
  }
}
