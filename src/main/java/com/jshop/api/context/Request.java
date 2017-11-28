package com.jshop.api.context;

import com.jshop.constant.OrderChannel;

/**
 * Created by yanglikai on 2017/9/19.
 */
public class Request {
  private String channel;

  private Request() {
  }

  public static Request builder() {
    return new Request();
  }

  /**
   * 渠道.
   *
   * @param channel 渠道
   * @return tihs
   */
  public Request withChannel(String channel) {
    this.channel =
        channel.toLowerCase().indexOf(OrderChannel.PC.key) > -1 ? OrderChannel.PC.value
            : channel.toLowerCase().indexOf(OrderChannel.IOS.key) > -1 ? OrderChannel.IOS.value
            : OrderChannel.ANDROID.value;
    return this;
  }

  public Request build() {
    return this;
  }

  public String getChannel() {
    return channel;
  }
}
