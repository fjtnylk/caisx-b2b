package com.jshop.model.entity.goods;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jshop.model.Do;
import com.jshop.model.domain.GoodsUnit;

/**
 * Created by yanglikai on 2017/9/8.
 */
@TableName(value = "jshop_goods")
public class GoodsDo extends Do {
  @TableId
  private Long id;
  @TableField
  private String goodsCode;
  @TableField
  private String goodsName;
  @TableField
  private GoodsUnit customeizeUnit;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGoodsCode() {
    return goodsCode;
  }

  public void setGoodsCode(String goodsCode) {
    this.goodsCode = goodsCode;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public GoodsUnit getCustomeizeUnit() {
    return customeizeUnit;
  }

  public void setCustomeizeUnit(GoodsUnit customeizeUnit) {
    this.customeizeUnit = customeizeUnit;
  }
}
