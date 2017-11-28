package com.jshop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Configuration
@ConfigurationProperties(prefix = "mysql")
public class JdbcProperties {
  private String writeUrl;
  private String writeUsername;
  private String writePassword;

  private String readUrl;
  private String readUsername;
  private String readPassword;

  private String filters;
  private String validationQuery;
  private Integer maxActive;
  private Integer initialSize;
  private Integer maxWait;
  private Integer minIdle;
  private Integer timeBetweenEvictionRunsMillis;
  private Integer minEvictableIdleTimeMillis;
  private Integer maxOpenPreparedStatements;
  private boolean testWhileIdle;
  private boolean testOnBorrow;
  private boolean testOnReturn;
  private boolean poolPreparedStatements;

  public String getWriteUrl() {
    return writeUrl;
  }

  public void setWriteUrl(String writeUrl) {
    this.writeUrl = writeUrl;
  }

  public String getWriteUsername() {
    return writeUsername;
  }

  public void setWriteUsername(String writeUsername) {
    this.writeUsername = writeUsername;
  }

  public String getWritePassword() {
    return writePassword;
  }

  public void setWritePassword(String writePassword) {
    this.writePassword = writePassword;
  }

  public String getReadUrl() {
    return readUrl;
  }

  public void setReadUrl(String readUrl) {
    this.readUrl = readUrl;
  }

  public String getReadUsername() {
    return readUsername;
  }

  public void setReadUsername(String readUsername) {
    this.readUsername = readUsername;
  }

  public String getReadPassword() {
    return readPassword;
  }

  public void setReadPassword(String readPassword) {
    this.readPassword = readPassword;
  }

  public String getFilters() {
    return filters;
  }

  public void setFilters(String filters) {
    this.filters = filters;
  }

  public String getValidationQuery() {
    return validationQuery;
  }

  public void setValidationQuery(String validationQuery) {
    this.validationQuery = validationQuery;
  }

  public Integer getMaxActive() {
    return maxActive;
  }

  public void setMaxActive(Integer maxActive) {
    this.maxActive = maxActive;
  }

  public Integer getInitialSize() {
    return initialSize;
  }

  public void setInitialSize(Integer initialSize) {
    this.initialSize = initialSize;
  }

  public Integer getMaxWait() {
    return maxWait;
  }

  public void setMaxWait(Integer maxWait) {
    this.maxWait = maxWait;
  }

  public Integer getMinIdle() {
    return minIdle;
  }

  public void setMinIdle(Integer minIdle) {
    this.minIdle = minIdle;
  }

  public Integer getTimeBetweenEvictionRunsMillis() {
    return timeBetweenEvictionRunsMillis;
  }

  public void setTimeBetweenEvictionRunsMillis(Integer timeBetweenEvictionRunsMillis) {
    this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
  }

  public Integer getMinEvictableIdleTimeMillis() {
    return minEvictableIdleTimeMillis;
  }

  public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
    this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
  }

  public Integer getMaxOpenPreparedStatements() {
    return maxOpenPreparedStatements;
  }

  public void setMaxOpenPreparedStatements(Integer maxOpenPreparedStatements) {
    this.maxOpenPreparedStatements = maxOpenPreparedStatements;
  }

  public boolean isTestWhileIdle() {
    return testWhileIdle;
  }

  public void setTestWhileIdle(boolean testWhileIdle) {
    this.testWhileIdle = testWhileIdle;
  }

  public boolean isTestOnBorrow() {
    return testOnBorrow;
  }

  public void setTestOnBorrow(boolean testOnBorrow) {
    this.testOnBorrow = testOnBorrow;
  }

  public boolean isTestOnReturn() {
    return testOnReturn;
  }

  public void setTestOnReturn(boolean testOnReturn) {
    this.testOnReturn = testOnReturn;
  }

  public boolean isPoolPreparedStatements() {
    return poolPreparedStatements;
  }

  public void setPoolPreparedStatements(boolean poolPreparedStatements) {
    this.poolPreparedStatements = poolPreparedStatements;
  }
}
