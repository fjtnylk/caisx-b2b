package com.jshop.model.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanglikai on 2017/9/14.
 */
public class DateInfo implements Serializable {
  private static final Map<Integer, String> weekMap = new HashMap<>();

  private String date;
  private String day;
  private String week;

  static {
    weekMap.put(0, "");
    weekMap.put(1, "周一");
    weekMap.put(2, "周二");
    weekMap.put(3, "周三");
    weekMap.put(4, "周四");
    weekMap.put(5, "周五");
    weekMap.put(6, "周六");
    weekMap.put(7, "周日");
  }

  private DateInfo() {
  }

  public static DateInfo builder() {
    return new DateInfo();
  }

  public DateInfo withDate(String date) {
    this.date = date;
    return this;
  }

  public DateInfo withDay(String day) {
    this.day = day;
    return this;
  }

  public DateInfo withWeek(int week) {
    this.week = parseWeek(week);
    return this;
  }

  private String parseWeek(int week) {
    return weekMap.get(week);
  }

  public DateInfo build() {
    return this;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public String getWeek() {
    return week;
  }

  public void setWeek(String week) {
    this.week = week;
  }
}
