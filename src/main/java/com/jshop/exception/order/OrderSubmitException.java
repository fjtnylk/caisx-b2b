package com.jshop.exception.order;

import com.jshop.constant.StatusCode;

/**
 * Created by yanglikai on 2017/9/14.
 */
public class OrderSubmitException extends OrderServiceException {
  public OrderSubmitException() {
    super(StatusCode.CODE_53001.code(), StatusCode.CODE_53001.msg());
  }
}
