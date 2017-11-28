package com.jshop.model.vo.goods;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.common.collect.Lists;
import com.jshop.model.Vo;
import java.util.List;

/**
 * Created by yanglikai on 2017/9/6.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GoodsDtlVo extends Vo {
  private Integer count;
  private List<GoodsInfoVo> dtl;

  private GoodsDtlVo() {
    this.count = 0;
    this.dtl = Lists.newArrayList();
  }

  public static GoodsDtlVo empty() {
    return new GoodsDtlVo();
  }

  public static GoodsDtlVo builder() {
    return new GoodsDtlVo();
  }

  public GoodsDtlVo withCount(Integer count) {
    this.count = count;
    return this;
  }

  public GoodsDtlVo withDtl(List<GoodsInfoVo> dtl) {
    this.dtl = dtl;
    return this;
  }

  public GoodsDtlVo build() {
    return this;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public List<GoodsInfoVo> getDtl() {
    return dtl;
  }

  public void setDtl(List<GoodsInfoVo> dtl) {
    this.dtl = dtl;
  }
}
