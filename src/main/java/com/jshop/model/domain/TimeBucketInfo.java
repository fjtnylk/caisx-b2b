package com.jshop.model.domain;

import java.io.Serializable;

/**
 * Created by yanglikai on 2017/9/14.
 */
public class TimeBucketInfo implements Serializable {
  private String start;
  private String end;

  private TimeBucketInfo() {
  }

  public static TimeBucketInfo builder() {
    return new TimeBucketInfo();
  }

  public TimeBucketInfo withStart(String start) {
    this.start = start;
    return this;
  }

  public TimeBucketInfo withEnd(String end) {
    this.end = end;
    return this;
  }

  public TimeBucketInfo build() {
    return this;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }
}
