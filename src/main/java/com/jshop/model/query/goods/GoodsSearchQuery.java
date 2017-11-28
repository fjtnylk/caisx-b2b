package com.jshop.model.query.goods;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Query;

/**
 * Created by yanglikai on 2017/9/8.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GoodsSearchQuery extends Query {
  private String q;
  private Integer page;

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public String getQ() {
    return q;
  }

  public void setQ(String q) {
    this.q = q;
  }
}
