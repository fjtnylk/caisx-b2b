package com.jshop.model.vo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.vo.order.OrderListVo;
import com.jshop.model.vo.user.UserIndexVo;
import java.util.List;

/**
 * Created by yanglikai on 2017/9/6.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IndexLoadVo {
  private String serviceTel;
  private UserIndexVo user;
  private List<OrderListVo> lastOrder;

  private IndexLoadVo() {
  }

  public static IndexLoadVo builder() {
    return new IndexLoadVo();
  }

  public IndexLoadVo withServiceTel(String serviceTel) {
    this.serviceTel = serviceTel;
    return this;
  }

  public IndexLoadVo withUser(UserIndexVo user) {
    this.user = user;
    return this;
  }

  public IndexLoadVo withLastOrder(List<OrderListVo> lastOrder) {
    this.lastOrder = lastOrder;
    return this;
  }

  public IndexLoadVo build() {
    return this;
  }

  public UserIndexVo getUser() {
    return user;
  }

  public void setUser(UserIndexVo user) {
    this.user = user;
  }

  public List<OrderListVo> getLastOrder() {
    return lastOrder;
  }

  public void setLastOrder(List<OrderListVo> lastOrder) {
    this.lastOrder = lastOrder;
  }

  public String getServiceTel() {
    return serviceTel;
  }

  public void setServiceTel(String serviceTel) {
    this.serviceTel = serviceTel;
  }
}
