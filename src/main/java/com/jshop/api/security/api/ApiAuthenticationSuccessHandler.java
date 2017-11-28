package com.jshop.api.security.api;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class ApiAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    request.getRequestDispatcher(request.getRequestURI()).forward(request, response);
  }

  /**
   * 认证成功后处理.
   *
   * @param request        请求实例
   * @param response       响应实例
   * @param chain          过滤链
   * @param authentication 认证信息
   * @throws IOException      IO异常
   * @throws ServletException Servlet异常
   */
  public void onAuthenticationSuccess(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain, Authentication authentication) throws IOException, ServletException {
    chain.doFilter(request, response);
  }
}
