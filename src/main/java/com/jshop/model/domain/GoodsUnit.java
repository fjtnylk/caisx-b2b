package com.jshop.model.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.jshop.model.vo.goods.GoodsSearchTagsVo;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by yanglikai on 2017/9/8.
 */
public class GoodsUnit implements Serializable {
  private JSONObject unit;

  private GoodsUnit(String text) {
    unit = JSON.parseObject(text);
  }

  public static GoodsUnit builder(String text) {
    return new GoodsUnit(text);
  }

  public GoodsUnit build() {
    return this;
  }

  public Set<String> keys() {
    return unit.keySet();
  }

  /**
   * 单位字面量.
   *
   * @return 单位字面量集合
   */
  public List<GoodsSearchTagsVo> values() {
    if (unit == null) {
      return Lists.newArrayList();
    }

    List<GoodsSearchTagsVo> tags = Lists.newArrayListWithCapacity(unit.keySet().size());
    for (String key : unit.keySet()) {
      String value = unit.getString(key);

      tags.add(
          GoodsSearchTagsVo.builder()
              .withCode(key)
              .withName(value)
              .build());
    }

    return tags;
  }

  public JSONObject getUnit() {
    return unit;
  }

  public void setUnit(JSONObject unit) {
    this.unit = unit;
  }
}
