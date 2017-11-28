package com.jshop.api.exception;

import com.jshop.constant.StatusCode;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class UsernameAuthenticationFailureException extends JshopAuthenticationException {

  public UsernameAuthenticationFailureException() {
    super(StatusCode.CODE_52001.code(), StatusCode.CODE_52001.msg());
  }
}
