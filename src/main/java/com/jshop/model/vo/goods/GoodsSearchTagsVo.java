package com.jshop.model.vo.goods;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Vo;

/**
 * Created by yanglikai on 2017/9/19.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GoodsSearchTagsVo extends Vo {
  private String code;
  private String name;

  private GoodsSearchTagsVo() {
  }

  public static GoodsSearchTagsVo builder() {
    return new GoodsSearchTagsVo();
  }

  public GoodsSearchTagsVo withCode(String code) {
    this.code = code;
    return this;
  }

  public GoodsSearchTagsVo withName(String name) {
    this.name = name;
    return this;
  }

  public GoodsSearchTagsVo build() {
    return this;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
