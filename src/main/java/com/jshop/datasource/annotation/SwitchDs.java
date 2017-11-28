package com.jshop.datasource.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 切换数据源.
 *
 * @author by yanglikai on 17/9/5.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface SwitchDs {
  /**
   * 多数据源切换.
   *
   * @return 主从标识
   */
  DbMsEnum ms() default DbMsEnum.JSHOP_USER;
}
