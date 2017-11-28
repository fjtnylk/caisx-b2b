package com.jshop.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.jshop.datasource.DynamicDataSource;
import com.jshop.datasource.DynamicDataSourceHolder;
import com.jshop.datasource.annotation.DbMsEnum;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Configuration
@AutoConfigureAfter({JdbcProperties.class})
@EnableTransactionManagement
public class DatasourceConfig {
  @Resource
  private JdbcProperties jdbcProperties;

  /**
   * 初始化用户数据源.
   *
   * @return 用户数据源实例
   * @throws SQLException SQLException
   */
  @Bean(name = "userDs", initMethod = "init", destroyMethod = "close")
  @Primary
  public DruidDataSource userDs() throws SQLException {
    DruidDataSource masterDs = new DruidDataSource();
    masterDs.setUrl(jdbcProperties.getWriteUrl());
    masterDs.setUsername(jdbcProperties.getWriteUsername());
    masterDs.setPassword(jdbcProperties.getWritePassword());

    masterDs.setFilters(jdbcProperties.getFilters());
    masterDs.setMaxActive(jdbcProperties.getMaxActive());
    masterDs.setInitialSize(jdbcProperties.getInitialSize());
    masterDs.setMaxWait(jdbcProperties.getMaxWait());
    masterDs.setMinIdle(jdbcProperties.getMinIdle());

    masterDs.setTimeBetweenEvictionRunsMillis(jdbcProperties.getTimeBetweenEvictionRunsMillis());
    masterDs.setMinEvictableIdleTimeMillis(jdbcProperties.getMinEvictableIdleTimeMillis());

    masterDs.setValidationQuery(jdbcProperties.getValidationQuery());
    masterDs.setTestWhileIdle(jdbcProperties.isTestWhileIdle());
    masterDs.setTestOnBorrow(jdbcProperties.isTestOnBorrow());
    masterDs.setTestOnReturn(jdbcProperties.isTestOnReturn());

    masterDs.setPoolPreparedStatements(jdbcProperties.isPoolPreparedStatements());
    masterDs.setMaxOpenPreparedStatements(jdbcProperties.getMaxOpenPreparedStatements());
    return masterDs;
  }

  /**
   * 初始化共通数据源.
   *
   * @return 共通数据源实例
   * @throws SQLException SQLException
   */
  @Bean(name = "commonDs", initMethod = "init", destroyMethod = "close")
  public DruidDataSource commonDs() throws SQLException {
    DruidDataSource slaveDs = new DruidDataSource();
    slaveDs.setUrl(jdbcProperties.getReadUrl());
    slaveDs.setUsername(jdbcProperties.getReadUsername());
    slaveDs.setPassword(jdbcProperties.getReadPassword());

    slaveDs.setFilters(jdbcProperties.getFilters());
    slaveDs.setMaxActive(jdbcProperties.getMaxActive());
    slaveDs.setInitialSize(jdbcProperties.getInitialSize());
    slaveDs.setMaxWait(jdbcProperties.getMaxWait());
    slaveDs.setMinIdle(jdbcProperties.getMinIdle());

    slaveDs.setTimeBetweenEvictionRunsMillis(jdbcProperties.getTimeBetweenEvictionRunsMillis());
    slaveDs.setMinEvictableIdleTimeMillis(jdbcProperties.getMinEvictableIdleTimeMillis());

    slaveDs.setValidationQuery(jdbcProperties.getValidationQuery());
    slaveDs.setTestWhileIdle(jdbcProperties.isTestWhileIdle());
    slaveDs.setTestOnBorrow(jdbcProperties.isTestOnBorrow());
    slaveDs.setTestOnReturn(jdbcProperties.isTestOnReturn());

    slaveDs.setPoolPreparedStatements(jdbcProperties.isPoolPreparedStatements());
    slaveDs.setMaxOpenPreparedStatements(jdbcProperties.getMaxOpenPreparedStatements());
    return slaveDs;
  }

  /**
   * 初始化事务数据源.
   *
   * @return 事务数据源实例
   * @throws SQLException SQLException
   */
  @Bean(name = "dataSource")
  public DynamicDataSource dataSource() throws SQLException {
    DynamicDataSource dynamicDataSource = new DynamicDataSource();
    dynamicDataSource.setDefaultTargetDataSourceName(DbMsEnum.JSHOP_USER.get());

    Map<Object, Object> targets = new HashMap<>();
    targets.put(DbMsEnum.JSHOP_USER.get(), userDs());
    targets.put(DbMsEnum.JSHOP_COMMON.get(), commonDs());
    dynamicDataSource.setTargetDataSources(targets);
    DynamicDataSourceHolder.putDataSource(DbMsEnum.JSHOP_USER.get());
    return dynamicDataSource;
  }
}
