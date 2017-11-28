package com.jshop.api.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by yanglikai on 2017/9/6.
 */
public class JshopAuthenticationException extends AuthenticationException {
  private int code;
  private String msg;

  public JshopAuthenticationException(String msg) {
    super(msg);
  }

  /**
   * 构造函数.
   *
   * @param code 错误编号
   * @param msg 错误信息
   */
  public JshopAuthenticationException(int code, String msg) {
    super(code + ":" + msg);
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
