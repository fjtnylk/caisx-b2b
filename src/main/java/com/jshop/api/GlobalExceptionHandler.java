package com.jshop.api;

import com.jshop.constant.StatusCode;
import com.jshop.exception.order.OrderServiceException;
import com.jshop.exception.user.UserServiceException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yanglikai on 2017/9/5.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * 验证异常处理.
   *
   * @param e 异常
   * @return 失败结果返回
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public ApiResult handleValidException(MethodArgumentNotValidException e) {
    List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
    for (FieldError error : fieldErrors) {
      return ApiResult.faild(StatusCode.CODE_41001.code(), error.getDefaultMessage());
    }

    return ApiResult.faild(StatusCode.CODE_41002.code(), StatusCode.CODE_41002.msg());
  }

  /**
   * 验证异常处理.
   *
   * @param e 异常
   * @return 失败结果返回
   */
  @ExceptionHandler(BindException.class)
  @ResponseBody
  public ApiResult handleBindException(BindException e) {
    List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
    for (FieldError error : fieldErrors) {
      return ApiResult.faild(StatusCode.CODE_41001.code(), error.getDefaultMessage());
    }

    return ApiResult.faild(StatusCode.CODE_41002.code(), StatusCode.CODE_41002.msg());
  }

  /**
   * 请求参数错误异常.
   *
   * @param e 异常
   * @return 失败结果返回
   */
  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseBody
  public ApiResult handleBadRequestException(HttpMessageNotReadableException e) {
    log.error(e.getMessage());
    return ApiResult.faild(StatusCode.CODE_41002.code(), StatusCode.CODE_41002.msg());
  }

  /**
   * 不支持类型异常.
   *
   * @param e 不支持类型异常
   * @return 失败结果返回
   */
  @ExceptionHandler(UnsupportedOperationException.class)
  @ResponseBody
  public ApiResult handleUnsuppotedOptException(UnsupportedOperationException e) {
    log.error(e.getMessage());
    return ApiResult.faild(StatusCode.CODE_41002.code(), e.getMessage());
  }

  /**
   * SQL异常.
   *
   * @param e SQL异常
   * @return 失败结果返回
   */
  @ExceptionHandler(BadSqlGrammarException.class)
  @ResponseBody
  public ApiResult handleBadSqlGrammarException(BadSqlGrammarException e) {
    log.error(e.getMessage());
    return ApiResult.faild(StatusCode.CODE_51002.code(), StatusCode.CODE_51002.msg());
  }

  /**
   * 用户异常.
   *
   * @param e 用户异常
   * @return 失败结果返回
   */
  @ExceptionHandler(UserServiceException.class)
  @ResponseBody
  public ApiResult handleUserServiceException(UserServiceException e) {
    return ApiResult.faild(e.getCode(), e.getMsg());
  }

  /**
   * 订单异常.
   *
   * @param e 订单异常
   * @return 失败结果返回
   */
  @ExceptionHandler(OrderServiceException.class)
  @ResponseBody
  public ApiResult handleOrderServiceException(OrderServiceException e) {
    return ApiResult.faild(e.getCode(), e.getMsg());
  }
}
