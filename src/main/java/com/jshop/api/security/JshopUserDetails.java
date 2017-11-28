package com.jshop.api.security;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class JshopUserDetails implements UserDetails {
  private Long userId;
  private String userName;
  private String mobile;
  private String custCode;
  private List<GrantedAuthority> authorities;

  public JshopUserDetails() {
  }

  /**
   * 构造函数.
   *
   * @param userId      userId
   * @param userName    userName
   * @param mobile      mobile
   * @param authorities authorities
   * @param custCode custCode
   */
  public JshopUserDetails(
      Long userId,
      String userName,
      String mobile,
      List<GrantedAuthority> authorities,
      String custCode) {
    this.userId = userId;
    this.userName = userName;
    this.mobile = mobile;
    this.authorities = authorities;
    this.custCode = custCode;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public void setAuthorities(List<GrantedAuthority> authorities) {
    this.authorities = authorities;
  }

  public String getCustCode() {
    return custCode;
  }

  public void setCustCode(String custCode) {
    this.custCode = custCode;
  }
}
