package com.jshop.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanglikai on 2017/8/24.
 */
public class IpUtils {

  /**
   * 获取ip地址.
   *
   * @param request 请求实例
   * @return ip地址
   */
  public static String getIpAddr(HttpServletRequest request) {
    String ip = request.getHeader("X-Real-IP");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("x-forwarded-for");
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }

    //防止多级代理时返回过个ip。
    if (ip != null && ip.indexOf(",") != -1) {
      ip = ip.substring(0, ip.indexOf(","));
    }
    return ip;
  }
}
