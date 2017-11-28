package com.jshop.api.exception;

import com.jshop.constant.StatusCode;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class TokenInvalidException extends JshopAuthenticationException {

  public TokenInvalidException() {
    super(StatusCode.CODE_42001.code(), StatusCode.CODE_42001.msg());
  }
}
