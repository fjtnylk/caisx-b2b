package com.jshop.model.domain;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import org.springframework.util.StringUtils;

/**
 * Created by yanglikai on 2017/9/8.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CodeName implements Serializable {
  private String code;
  private String name;

  private CodeName() {
  }

  /**
   * 构建List.
   *
   * @param userOrderType 订单类型
   * @return list集合实例
   */
  public static List<CodeName> builderList(String userOrderType) {
    if (StringUtils.isEmpty(userOrderType)) {
      return Lists.newArrayList();
    }

    List<String> list = JSON.parseArray(userOrderType, String.class);
    List<CodeName> result = Lists.newArrayListWithCapacity(list.size());
    for (String name : list) {
      result.add(
          CodeName.builder()
              .withCode("")
              .withName(name)
              .build());
    }


    return result;
  }

  public static CodeName builder() {
    return new CodeName();
  }

  public CodeName withCode(String code) {
    this.code = code;
    return this;
  }

  public CodeName withName(String name) {
    this.name = name;
    return this;
  }

  public CodeName build() {
    return this;
  }

  public List<CodeName> buildList() {
    return Lists.newArrayList();
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
