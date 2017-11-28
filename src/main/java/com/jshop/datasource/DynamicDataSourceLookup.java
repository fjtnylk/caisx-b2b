package com.jshop.datasource;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;

/**
 * Created by yanglikai on 2017/9/5.
 */
public class DynamicDataSourceLookup implements DataSourceLookup {
  private final DynamicDataSource dataSource;

  public DynamicDataSourceLookup(DynamicDataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public DataSource getDataSource(String dataSourceName) throws DataSourceLookupFailureException {
    return dataSource;
  }
}
