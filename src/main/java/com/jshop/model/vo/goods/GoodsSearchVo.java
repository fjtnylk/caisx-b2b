package com.jshop.model.vo.goods;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Vo;
import java.util.List;

/**
 * Created by yanglikai on 2017/9/8.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GoodsSearchVo extends Vo {
  private String goodsCode;
  private String title;
  private List<GoodsSearchTagsVo> tags;

  private GoodsSearchVo() {
  }

  public static GoodsSearchVo builder() {
    return new GoodsSearchVo();
  }

  public static GoodsSearchVo empty() {
    return new GoodsSearchVo();
  }

  public GoodsSearchVo withCode(String goodsCode) {
    this.goodsCode = goodsCode;
    return this;
  }

  public GoodsSearchVo withTitle(String title) {
    this.title = title;
    return this;
  }

  public GoodsSearchVo withTags(List<GoodsSearchTagsVo> tags) {
    this.tags = tags;
    return this;
  }

  public GoodsSearchVo build() {
    return this;
  }

  public String getGoodsCode() {
    return goodsCode;
  }

  public void setGoodsCode(String goodsCode) {
    this.goodsCode = goodsCode;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<GoodsSearchTagsVo> getTags() {
    return tags;
  }

  public void setTags(List<GoodsSearchTagsVo> tags) {
    this.tags = tags;
  }
}
