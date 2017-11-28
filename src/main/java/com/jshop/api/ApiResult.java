package com.jshop.api;

import com.jshop.constant.StatusCode;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class ApiResult {
  private static final int SUCCESS_CODE = StatusCode.CODE_10000.code();
  private static final int BIZ_ERR_CODE = 40004;

  private static final String SUCCESS_MSG = "ok";
  private static final String BIZ_ERR_MSG = "业务处理失败";

  private int code;
  private String message;
  private Object data;

  /**
   * 构造函数.
   *
   * @param code    接口返回编码
   * @param message 接口返回消息
   * @param data    接口返回数据
   */
  public ApiResult(int code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  /**
   * 接口处理成功.
   *
   * @return 接口返回结果
   */
  public static ApiResult success() {
    return new ApiResult(SUCCESS_CODE, SUCCESS_MSG, null);
  }

  /**
   * 接口处理成功重载.
   *
   * @param data 接口返回数据
   * @return 接口返回结果
   */
  public static ApiResult success(Object data) {
    return new ApiResult(SUCCESS_CODE, SUCCESS_MSG, data);
  }

  /**
   * 接口处理失败.
   *
   * @return 接口返回结果
   */
  public static ApiResult faild() {
    return new ApiResult(BIZ_ERR_CODE, BIZ_ERR_MSG, null);
  }

  /**
   * 接口处理失败重载.
   *
   * @param errMsg 错误信息
   * @return 接口返回结果
   */
  public static ApiResult faild(String errMsg) {
    return new ApiResult(BIZ_ERR_CODE, errMsg, null);
  }

  /**
   * 接口处理失败重载.
   *
   * @param errCode 错误编号
   * @param errMsg  错误信息
   * @return 接口返回结果
   */
  public static ApiResult faild(int errCode, String errMsg) {
    return new ApiResult(errCode, errMsg, null);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
