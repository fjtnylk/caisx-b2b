package com.jshop.datasource;

import com.jshop.datasource.annotation.SwitchDs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 数据源切面，拦截指定方法.
 *
 * @author by yanglikai on 17/9/5.
 */
@Aspect
@Component
@Order(0)
public class DataSourceAspect {
  private static final Logger log = LoggerFactory.getLogger(DataSourceAspect.class);

  /**
   * 读写分离核心执行方法.
   *
   * @param point point
   * @param ds    ds
   * @throws Throwable Throwable
   */
  @Before(value = "@annotation(ds)")
  public void before(JoinPoint point, SwitchDs ds) throws Throwable {
    if (log.isDebugEnabled()) {
      log.debug(String.format("switch ds is %s", ds.ms().get()));
    }
    DynamicDataSourceHolder.putDataSource(ds.ms().get());
  }
}
