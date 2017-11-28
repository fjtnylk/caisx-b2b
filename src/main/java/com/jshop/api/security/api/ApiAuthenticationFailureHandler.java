package com.jshop.api.security.api;

import com.alibaba.fastjson.JSON;
import com.jshop.api.ApiResult;
import com.jshop.api.exception.JshopAuthenticationException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class ApiAuthenticationFailureHandler implements AuthenticationFailureHandler {
  @Override
  public void onAuthenticationFailure(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException e) throws IOException, ServletException {
    JshopAuthenticationException exception = (JshopAuthenticationException) e;

    response.setCharacterEncoding("UTF-8");
    PrintWriter writer = response.getWriter();
    writer.write(JSON.toJSONString(ApiResult.faild(exception.getCode(), exception.getMsg())));
    writer.flush();
    writer.close();
  }
}
