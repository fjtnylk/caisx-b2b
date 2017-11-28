package com.jshop.constant;

/**
 * Created by yanglikai on 2017/9/19.
 */
public enum OrderChannel {
  PC("windows", "pc", "电脑网页版"),
  IOS("mac", "ios", "ios系统"),
  ANDROID("android", "android", "android系统");

  public String key;
  public String value;
  public String desc;

  OrderChannel(String key, String value, String desc) {
    this.key = key;
    this.value = value;
    this.desc = desc;
  }
}
