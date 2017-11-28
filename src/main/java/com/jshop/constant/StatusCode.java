package com.jshop.constant;

/**
 * Created by yanglikai on 2017/9/5.
 */
public enum StatusCode {
  CODE_10000(10000, "请求成功"),

  CODE_41001(41001, "缺少必要参数"),
  CODE_41002(41002, "请求参数错误"),
  CODE_41003(41003, "参数类型错误"),

  CODE_42001(42001, "无效的令牌"),
  CODE_42002(42002, "令牌已失效"),
  CODE_42003(42003, "用户名密码无效"),

  CODE_51001(51001, "服务请求失败，请重试"),
  CODE_51002(51002, "服务请求异常，请联系管理员"),

  CODE_52001(52001, "用户认证失败"),
  CODE_52002(52002, "访问权限不足"),

  CODE_53001(53001, "订单提交失败"),

  CODE_54001(54001, "用户履约信息不存在"),
  ;

  private final int code;
  private final String msg;

  StatusCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  /**
   * 状态编码.
   *
   * @return 状态编码
   */
  public int code() {
    return this.code;
  }

  /**
   * 状态消息.
   *
   * @return 状态消息
   */
  public String msg() {
    return this.msg;
  }
}
