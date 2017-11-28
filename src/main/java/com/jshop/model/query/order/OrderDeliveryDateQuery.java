package com.jshop.model.query.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jshop.model.Query;
import org.joda.time.DateTime;

/**
 * Created by yanglikai on 2017/9/15.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderDeliveryDateQuery extends Query {
  private String date;
  private String timeBucket;
  private String day;
  private String week;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTimeBucket() {
    return timeBucket;
  }

  public void setTimeBucket(String timeBucket) {
    this.timeBucket = timeBucket;
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

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb
        .append(new DateTime(date).toString("MM")).append("月")
        .append(new DateTime(date).toString("dd")).append("日")
        .append(" ")
        .append(day)
        .append(week)
        .append(" ")
        .append(timeBucket);
    return sb.toString();
  }
}
