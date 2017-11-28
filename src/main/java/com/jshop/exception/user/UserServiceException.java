package com.jshop.exception.user;

/**
 * Created by yanglikai on 2017/9/6.
 */
public class UserServiceException extends Exception {
  private int code;
  private String msg;

  public UserServiceException() {
    super();
  }

  /**
   * 构造函数.
   *
   * @param code 错误编码
   * @param msg 错误信息
   */
  public UserServiceException(int code, String msg) {
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
