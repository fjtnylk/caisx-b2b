package com.jshop.api.security.api;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class ApiAuthenticationToken extends AbstractAuthenticationToken {
  private String token;
  private final Object principal;
  private Object credentials;

  /**
   * 构造函数.
   *
   * @param token 令牌标识
   */
  public ApiAuthenticationToken(String token) {
    super(null);
    this.token = token;
    this.principal = null;
    this.credentials = null;
  }

  /**
   * 构造函数.
   *
   * @param principal   principal
   * @param credentials credentials
   */
  public ApiAuthenticationToken(Object principal, Object credentials) {
    super(null);
    this.principal = principal;
    this.credentials = credentials;
    setAuthenticated(false);
  }

  /**
   * 构造函数.
   *
   * @param principal   principal
   * @param credentials credentials
   * @param authorities authorities
   */
  public ApiAuthenticationToken(
      Object principal,
      Object credentials,
      Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    this.credentials = credentials;
    super.setAuthenticated(true);
  }

  @Override
  public Object getCredentials() {
    return credentials;
  }

  @Override
  public Object getPrincipal() {
    return principal;
  }

  public String getToken() {
    return token;
  }
}
