package com.jshop.api.security.api;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class ApiAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
  @Resource
  private AuthenticationManager authenticationManager;
  @Resource
  private AuthenticationSuccessHandler authenticationSuccessHandler;
  @Resource
  private AuthenticationFailureHandler authenticationFailureHandler;

  public ApiAuthenticationFilter() {
    super(new AntPathRequestMatcher("/api/**"));
  }

  /**
   * 初始化.
   */
  @PostConstruct
  public void init() {
    super.setAuthenticationManager(authenticationManager);
    super.setAuthenticationSuccessHandler(authenticationSuccessHandler);
    super.setAuthenticationFailureHandler(authenticationFailureHandler);
  }

  /**
   * 认证.
   *
   * @param request  请求实例
   * @param response 响应实例
   * @return 认证信息
   * @throws AuthenticationException 认证异常
   * @throws IOException             IO异常
   * @throws ServletException        Servlet异常
   */
  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request,
      HttpServletResponse response)
      throws AuthenticationException, IOException, ServletException {
    String token = obtainToken(request);
    if (token == null) {
      token = "";
    }

    ApiAuthenticationToken authRequest = new ApiAuthenticationToken(token);

    setDetails(request, authRequest);

    return this.authenticationManager.authenticate(authRequest);
  }

  /**
   * 获取token.
   *
   * @param request 请求实例
   * @return token
   */
  protected String obtainToken(HttpServletRequest request) {
    return request.getHeader("X-API-Token");
  }

  /**
   * 设置详情.
   *
   * @param request     请求实例
   * @param authRequest 认证token
   */
  protected void setDetails(HttpServletRequest request, ApiAuthenticationToken authRequest) {
    authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
  }

  /**
   * 成功认证处理.
   *
   * @param request    请求实例
   * @param response   响应实例
   * @param chain      过滤链
   * @param authResult 认证token
   * @throws IOException      IO异常
   * @throws ServletException servlet异常
   */
  @Override
  protected void successfulAuthentication(HttpServletRequest request,
                                          HttpServletResponse response,
                                          FilterChain chain,
                                          Authentication authResult)
      throws IOException, ServletException {

    if (logger.isDebugEnabled()) {
      logger.debug("Authentication success. Updating SecurityContextHolder to contain: "
          + authResult);
    }

    SecurityContextHolder.getContext().setAuthentication(authResult);

    if (this.eventPublisher != null) {
      eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(
          authResult, this.getClass()));
    }

    ApiAuthenticationSuccessHandler apiAuthenticationSuccessHandler =
        (ApiAuthenticationSuccessHandler) super.getSuccessHandler();
    apiAuthenticationSuccessHandler.onAuthenticationSuccess(request, response, chain, authResult);
  }
}
