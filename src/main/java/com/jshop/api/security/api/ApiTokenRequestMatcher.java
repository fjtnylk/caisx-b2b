package com.jshop.api.security.api;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class ApiTokenRequestMatcher implements RequestMatcher {
  private final String expectedHeaderName;
  private final String expectedHeaderValue;

  public ApiTokenRequestMatcher(String expectedHeaderName) {
    this(expectedHeaderName, null);
  }

  public ApiTokenRequestMatcher(String expectedHeaderName,
                                String expectedHeaderValue) {
    this.expectedHeaderName = expectedHeaderName;
    this.expectedHeaderValue = expectedHeaderValue;
  }

  @Override
  public boolean matches(HttpServletRequest request) {
    String actualHeaderValue = request.getHeader(expectedHeaderName);
    if (expectedHeaderValue == null) {
      return actualHeaderValue != null;
    }

    return expectedHeaderValue.equals(actualHeaderValue);
  }
}
