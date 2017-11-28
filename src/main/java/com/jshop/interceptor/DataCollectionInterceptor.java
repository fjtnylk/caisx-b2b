package com.jshop.interceptor;

import com.jshop.api.context.Request;
import com.jshop.api.context.RequestContext;
import com.jshop.api.context.UserContext;
import com.jshop.log.CollectionValue;
import com.jshop.log.DataCollectionLog;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class DataCollectionInterceptor extends HandlerInterceptorAdapter {
  @Override
  public boolean preHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler) throws Exception {
    long userId = UserContext.getUserId();
    String userName = UserContext.getUserName();
    // 1.解析请求日志
    CollectionValue log = CollectionValue.init(request, userId, userName);
    DataCollectionLog.log(log);
    // 2.设置请求上下文
    RequestContext.setContext(
        Request.builder()
            .withChannel(log.getBrowser())
            .build());
    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView) throws Exception {
  }

  @Override
  public void afterCompletion(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      Exception ex) throws Exception {
  }
}
