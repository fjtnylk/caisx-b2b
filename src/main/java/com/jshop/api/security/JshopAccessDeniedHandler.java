package com.jshop.api.security;

import com.alibaba.fastjson.JSON;
import com.jshop.api.ApiResult;
import com.jshop.constant.StatusCode;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class JshopAccessDeniedHandler implements AccessDeniedHandler {
  @Override
  public void handle(
      HttpServletRequest request,
      HttpServletResponse response,
      AccessDeniedException e) throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    PrintWriter writer = response.getWriter();
    writer.write(
        JSON.toJSONString(
            ApiResult.faild(StatusCode.CODE_52002.code(), StatusCode.CODE_52002.msg())));
    writer.flush();
    writer.close();
  }
}
