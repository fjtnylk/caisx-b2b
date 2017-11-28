package com.jshop.constant;

/**
 * Created by yanglikai on 2017/9/14.
 */
public enum SysConfigKey {
  JSHOP_SERVICE_TEL("jshop_service_tel", "客服电话");

  public final String key;
  public final String desc;

  SysConfigKey(String key, String desc) {
    this.key = key;
    this.desc = desc;
  }
}
