package com.jshop.api.context;

/**
 * Created by yanglikai on 2017/9 /19.
 */
public class RequestContext {
  private static final ThreadLocal<Request> request = new ThreadLocal<>();

  public static void clear() {
    request.remove();
  }

  public static Request getContext() {
    return request.get();
  }

  public static void setContext(Request target) {
    request.set(target);
  }
}
