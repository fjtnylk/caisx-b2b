package com.jshop.model.domain;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yanglikai on 2017/9/14.
 */
public class GoodsOriginalInfoList implements Serializable {
  private List<GoodsOriginalInfo> goodsOriginalInfos;

  private GoodsOriginalInfoList() {
    this.goodsOriginalInfos = Lists.newArrayListWithCapacity(3);
  }

  public static GoodsOriginalInfoList builder() {
    return new GoodsOriginalInfoList();
  }

  public GoodsOriginalInfoList withGoodsInfo(List<GoodsOriginalInfo> goodsInfo) {
    this.goodsOriginalInfos = goodsInfo;
    return this;
  }

  public GoodsOriginalInfoList add(GoodsOriginalInfo target) {
    this.goodsOriginalInfos.add(target);
    return this;
  }

  public GoodsOriginalInfoList build() {
    return this;
  }

  /**
   * 订单原始商品信息.
   *
   * @return 订单原始商品信息实例
   */
  public List<GoodsOriginalInfo> getGoodsOriginalInfos() {
    return goodsOriginalInfos == null
        ? Lists.newArrayListWithCapacity(0)
        : goodsOriginalInfos;
  }

  public void setGoodsOriginalInfos(List<GoodsOriginalInfo> goodsOriginalInfos) {
    this.goodsOriginalInfos = goodsOriginalInfos;
  }
}
