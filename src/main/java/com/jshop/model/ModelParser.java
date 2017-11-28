package com.jshop.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;

/**
 * Created by yanglikai on 2017/9/5.
 */
public final class ModelParser {

  /**
   * 实体集合解析.
   *
   * @param source 源
   * @param target 目标
   * @param <T>    泛型
   * @return 泛型集合实例
   */
  public static <T> List<T> parse(List source, Class<T> target) {
    List<T> list = new ArrayList<>(source.size());

    for (Object o : source) {
      T result = parse(o, target);
      list.add(result);
    }

    return list;
  }

  /**
   * 实体解析.
   *
   * @param source 源
   * @param target 目标
   * @param <T>    泛型
   * @return 泛型实例
   */
  public static <T> T parse(Object source, Class<T> target) {
    T result = BeanUtils.instantiate(target);
    BeanUtils.copyProperties(source, result);

    return result;
  }
}
