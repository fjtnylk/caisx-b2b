package com.jshop.model.domain;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yanglikai on 2017/9/7.
 */
public class GoodsRefundInfoList implements Serializable {
  private List<GoodsRefundInfo> refundInfos;

  private GoodsRefundInfoList() {
    this.refundInfos = Lists.newArrayListWithCapacity(3);
  }

  public static GoodsRefundInfoList empty() {
    return new GoodsRefundInfoList();
  }

  public static GoodsRefundInfoList builder() {
    return new GoodsRefundInfoList();
  }

  public GoodsRefundInfoList withRefundInfos(List<GoodsRefundInfo> refundInfos) {
    this.refundInfos = refundInfos;
    return this;
  }

  public GoodsRefundInfoList build() {
    return this;
  }

  /**
   * 合并退货商品信息.
   *
   * @param target 待合并数据
   * @return this
   */
  public GoodsRefundInfoList merge(GoodsRefundInfoList target) {
    this.refundInfos.addAll(
        target == null
            ? Lists.newArrayList()
            : target.getRefundInfos());
    return this;
  }

  /**
   * 是否存在退货商品.
   *
   * @param goodsCode 商品编号
   * @return 退货总数
   */
  public String containsCount(String goodsCode) {
    for (GoodsRefundInfo refundInfo : refundInfos) {
      if (refundInfo.getReturnGoodsCode().equals(goodsCode)) {
        return refundInfo.getReturnGoodsCount();
      }
    }

    return "0";
  }

  public List<GoodsRefundInfo> getRefundInfos() {
    return refundInfos;
  }

  public void setRefundInfos(List<GoodsRefundInfo> refundInfos) {
    this.refundInfos = refundInfos;
  }
}
