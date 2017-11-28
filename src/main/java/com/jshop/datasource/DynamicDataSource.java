package com.jshop.datasource;

import java.util.concurrent.ThreadPoolExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源，根据相应规则，可自主选择.
 *
 * @author by yanglikai on 17/9/5.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
  private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

  private String defaultTargetDataSourceName;

  @Override
  protected Object determineCurrentLookupKey() {
    Object obj = DynamicDataSourceHolder.getDataSource();
    if (log.isDebugEnabled()) {
      log.debug(String.format("get current datasource is %s", obj));
    }
    return obj;
  }

  public String getDefaultTargetDataSourceName() {
    return defaultTargetDataSourceName;
  }

  public void setDefaultTargetDataSourceName(String defaultTargetDataSourceName) {
    this.defaultTargetDataSourceName = defaultTargetDataSourceName;
  }
}
