package com.jshop.log;

import com.jshop.constant.Globals;
import com.jshop.utils.IpUtils;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * Created by yanglikai on 2017/8/24.
 */
public final class CollectionValue {
  private static final String USER_AGENT = "User-Agent";
  private static final String X_API_TOKEN = "X-API-Token";
  private static final String REFERER = "REFERER";

  private String time;
  private String url;
  private Long userId;
  private String userName;
  private String domain;
  private String refer;
  private String ip;
  private String token;
  private String browser;

  private CollectionValue(HttpServletRequest request, Long userId, String userName) {
    this.userId = userId;
    this.userName = userName;
    this.time = DateFormatUtils.format(new Date(), Globals.DATE_FORMAT_yyyy_MM_dd_HH_mm_ss_sss);
    this.url = request.getRequestURL().toString();
    this.domain = request.getServerName();
    this.refer = request.getHeader(REFERER);
    this.ip = IpUtils.getIpAddr(request);
    this.token = request.getHeader(X_API_TOKEN);
    this.browser = request.getHeader(USER_AGENT);
  }

  public static CollectionValue init(HttpServletRequest request, Long userId, String userName) {
    return new CollectionValue(request, userId, userName);
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getRefer() {
    return refer;
  }

  public void setRefer(String refer) {
    this.refer = refer;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getBrowser() {
    return browser;
  }

  public void setBrowser(String browser) {
    this.browser = browser;
  }
}
