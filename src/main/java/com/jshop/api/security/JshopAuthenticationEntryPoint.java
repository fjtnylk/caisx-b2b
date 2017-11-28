package com.jshop.api.security;

import com.alibaba.fastjson.JSON;
import com.jshop.api.ApiResult;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class JshopAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException e) throws IOException, ServletException {
    String token = request.getHeader("X-API-Token");
    if (StringUtils.isEmpty(token)) {
      response.setCharacterEncoding("UTF-8");
      PrintWriter writer = response.getWriter();
      writer.write(JSON.toJSONString(ApiResult.faild(20001, "缺少token标识")));
      writer.flush();
      writer.close();
      return;
    }

    response.setCharacterEncoding("UTF-8");
    PrintWriter writer = response.getWriter();
    writer.write(JSON.toJSONString(ApiResult.faild(20001, "授权权限不足")));
    writer.flush();
    writer.close();
  }
}
