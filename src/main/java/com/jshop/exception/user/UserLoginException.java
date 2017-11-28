package com.jshop.exception.user;

import com.jshop.constant.StatusCode;

/**
 * Created by yanglikai on 2017/9/6.
 */
public class UserLoginException extends UserServiceException {
  public UserLoginException() {
    super(StatusCode.CODE_42003.code(), StatusCode.CODE_42003.msg());
  }
}
