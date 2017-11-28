package com.jshop.api.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class TokenNotFoundException extends AuthenticationException {
  private static final String msg = "缺少token标识";

  public TokenNotFoundException() {
    super(msg);
  }

  public TokenNotFoundException(String msg, Throwable t) {
    super(msg, t);
  }

  public TokenNotFoundException(String msg) {
    super(msg);
  }
}
