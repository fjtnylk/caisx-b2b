package com.jshop.api.security;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class JshopUserDetailsBuilder {
  private Long userId;
  private String userName;
  private String mobile;
  private List<GrantedAuthority> authorities;
  private String custCode;

  /**
   * 构造器.
   *
   * @return this
   */
  public static JshopUserDetailsBuilder builder() {
    return new JshopUserDetailsBuilder();
  }

  public JshopUserDetailsBuilder withUserId(Long userId) {
    this.userId = userId;
    return this;
  }

  public JshopUserDetailsBuilder withUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public JshopUserDetailsBuilder withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public JshopUserDetailsBuilder withAuth(List<GrantedAuthority> authorities) {
    this.authorities = authorities;
    return this;
  }

  public JshopUserDetailsBuilder withCustCode(String custCode) {
    this.custCode = custCode;
    return this;
  }

  /**
   * anonymous权限.
   *
   * @return this
   */
  public JshopUserDetailsBuilder anonymous() {
    this.userId = 0L;
    this.userName = "";
    this.mobile = "";
    this.authorities = AuthorityUtils.createAuthorityList("ROLE_ANONYMOUS");
    this.custCode = "";
    return this;
  }

  public JshopUserDetails build() {
    return new JshopUserDetails(userId, userName, mobile, authorities, custCode);
  }
}
