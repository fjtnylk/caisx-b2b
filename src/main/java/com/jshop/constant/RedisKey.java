package com.jshop.constant;

/**
 * Created by yanglikai on 2017/9/5.
 */
public enum RedisKey {
  B2B_USER_TOKEN("b2b:user:token:%s", "用户Token", -1), // 无期限
  B2B_SYS_CONFIG("b2b:sys:config:%s", "系统配置", 60 * 60 * 24 * 30), // 一个月
  B2B_ORDER_CODE_INCREMENT("b2b:order:code:increment", "订单编号自增流水", -1) // 无期限
  ;


  public final String key;
  public final String desc;
  public final int expired;

  RedisKey(String key, String desc, int expired) {
    this.key = key;
    this.desc = desc;
    this.expired = expired;
  }
}
