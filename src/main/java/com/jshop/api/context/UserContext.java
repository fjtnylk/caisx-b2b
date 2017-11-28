package com.jshop.api.context;

import com.jshop.api.security.JshopUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by yanglikai on 2017/9/5..
 */
public final class UserContext {

  /**
   * 获取用户编号.
   *
   * @return 用户编号
   */
  public static Long getUserId() {
    SecurityContext ctx = SecurityContextHolder.getContext();
    if (ctx == null) {
      return 0L;
    }

    Authentication authentication = ctx.getAuthentication();
    if (authentication == null) {
      return 0L;
    }

    Object principal = authentication.getPrincipal();
    if (principal instanceof JshopUserDetails) {
      return ((JshopUserDetails) principal).getUserId();
    }

    return 0L;
  }

  /**
   * 获取用户名.
   *
   * @return 用户名
   */
  public static String getUserName() {
    SecurityContext ctx = SecurityContextHolder.getContext();
    if (ctx == null) {
      return null;
    }

    Authentication authentication = ctx.getAuthentication();
    if (authentication == null) {
      return null;
    }

    Object principal = authentication.getPrincipal();
    if (principal instanceof JshopUserDetails) {
      return ((JshopUserDetails) principal).getUserName();
    }

    return null;
  }

  /**
   * 获取手机号.
   *
   * @return 手机号
   */
  public static String getMobile() {
    SecurityContext ctx = SecurityContextHolder.getContext();
    if (ctx == null) {
      return null;
    }

    Authentication authentication = ctx.getAuthentication();
    if (authentication == null) {
      return null;
    }

    Object principal = authentication.getPrincipal();
    if (principal instanceof JshopUserDetails) {
      return ((JshopUserDetails) principal).getMobile();
    }

    return null;
  }
}
