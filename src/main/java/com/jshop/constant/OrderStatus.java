package com.jshop.constant;

/**
 * Created by yanglikai on 2017/9/6.
 */
public enum OrderStatus {
  ALL(-1, "全部"),
  RECEIVING_10(10, "待接单"),
  CANCEL_0(0, "已取消"),
  WAIT_SEND_15(15, "待发货"),
  DELIVERING_20(20, "配送中"),
  RECEIVED_25(25, "已收货"),
  RETURNED_35(35, "已退货");

  private final int code;
  private final String desc;

  OrderStatus(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public int code() {
    return this.code;
  }

  public String desc() {
    return this.desc;
  }

  /**
   * 状态编码解析为状态描述.
   *
   * @param code 状态编码
   * @return 状态描述
   */
  public static String parseFrom(int code) {
    for (OrderStatus orderStatus : OrderStatus.values()) {
      if (orderStatus.code == code) {
        return orderStatus.desc;
      }
    }

    return "未知状态";
  }
}
