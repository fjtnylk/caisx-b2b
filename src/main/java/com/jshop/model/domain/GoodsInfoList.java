package com.jshop.model.domain;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanglikai on 2017/9/6.
 */
public class GoodsInfoList implements Serializable {
  private List<GoodsInfo> goodsInfos;

  private GoodsInfoList() {
    this.goodsInfos = Lists.newArrayListWithCapacity(3);
  }

  public static GoodsInfoList empty() {
    return new GoodsInfoList();
  }

  public static GoodsInfoList builder() {
    return new GoodsInfoList();
  }

  public GoodsInfoList withGoodsInfos(List<GoodsInfo> goodsInfos) {
    this.goodsInfos = goodsInfos;
    return this;
  }

  /**
   * 添加商品信息.
   *
   * @param goodsInfo 商品信息实例
   * @return this
   */
  public GoodsInfoList add(GoodsInfo goodsInfo) {
    // 自定义商品不添加到订单商品内
    if (StringUtils.isNotBlank(goodsInfo.getGoods_code())) {
      this.goodsInfos.add(goodsInfo);
    }
    return this;
  }

  public GoodsInfoList merge(GoodsInfoList target) {
    this.goodsInfos.addAll(target == null ? Lists.newArrayList() : target.getGoodsInfos());
    return this;
  }

  public GoodsInfoList build() {
    return this;
  }

  public List<GoodsInfo> getGoodsInfos() {
    return goodsInfos;
  }

  public void setGoodsInfos(List<GoodsInfo> goodsInfos) {
    this.goodsInfos = goodsInfos;
  }
}
