package com.jshop.model.builder;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jshop.model.Do;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanglikai on 2017/8/21.
 */
public class EntityWrapperBuilder<T extends Do> {
  private EntityWrapper<T> entityWrapper;

  private EntityWrapperBuilder() {
    this.entityWrapper = new EntityWrapper<>();
  }

  public static <T extends Do> EntityWrapperBuilder<T> builder(Class<T> target) {
    return new EntityWrapperBuilder<>();
  }

  public EntityWrapperBuilder<T> where(String sqlWhere) {
    this.entityWrapper.where(sqlWhere);
    return this;
  }

  /**
   * where条件.
   *
   * @param sqlWhere sqlWhere
   * @param params   params
   * @return this
   */
  public EntityWrapperBuilder<T> where(String sqlWhere, String params) {
    if (StringUtils.isNotBlank(params)) {
      this.entityWrapper.where(sqlWhere, params);
    }

    return this;
  }

  /**
   * where条件.
   *
   * @param sqlWhere sqlWhere
   * @param params   params
   * @return this
   */
  public EntityWrapperBuilder<T> where(String sqlWhere, Long params) {
    if (params != null) {
      this.entityWrapper.where(sqlWhere, params);
    }

    return this;
  }

  /**
   * and条件.
   *
   * @param sqlAnd sqlAnd
   * @param params params
   * @return this
   */
  public EntityWrapperBuilder<T> and(String sqlAnd, String params) {
    if (StringUtils.isNotBlank(params)) {
      this.entityWrapper.and(sqlAnd, params);
    }

    return this;
  }

  /**
   * and条件.
   *
   * @param sqlAnd sqlAnd
   * @param params params
   * @return this
   */
  public EntityWrapperBuilder<T> and(String sqlAnd, Long params) {
    if (params != null) {
      this.entityWrapper.and(sqlAnd, params);
    }

    return this;
  }

  /**
   * and条件.
   *
   * @param sqlAnd sqlAnd
   * @param params params
   * @return this
   */
  public EntityWrapperBuilder<T> and(String sqlAnd, Integer params) {
    if ("order_status={0}".equals(sqlAnd) && params == -1) {
      return this;
    }

    if (params != null) {
      this.entityWrapper.and(sqlAnd, params);
    }

    return this;
  }

  /**
   * like条件.
   *
   * @param column column
   * @param value  value
   * @return this
   */
  public EntityWrapperBuilder<T> like(String column, String value) {
    if (StringUtils.isNotBlank(value)) {
      this.entityWrapper.like(true, column, value, SqlLike.DEFAULT);
    }

    return this;
  }

  /**
   * orderby.
   *
   * @param columns columns
   * @return this
   */
  public EntityWrapperBuilder orderBy(String columns) {
    this.entityWrapper.orderBy(columns, false);
    return this;
  }

  public EntityWrapper<T> getTarget() {
    return entityWrapper;
  }
}
