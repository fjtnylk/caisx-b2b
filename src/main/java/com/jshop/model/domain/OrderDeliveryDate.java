package com.jshop.model.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.common.collect.Lists;
import com.jshop.constant.Globals;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Created by yanglikai on 2017/9/8.
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderDeliveryDate implements Serializable {
  private List<DateInfo> dateInfo;
  private List<TimeBucketInfo> timeBucketInfo;

  private OrderDeliveryDate(List<DateInfo> dateInfoList, List<TimeBucketInfo> timeBucketInfoList) {
    this.dateInfo = dateInfoList;
    this.timeBucketInfo = timeBucketInfoList;
  }

  /**
   * 构建配送日期.
   *
   * @param time 日期
   * @return this
   */
  public static OrderDeliveryDate builder(String time) {
    // 1.日期
    List<DateInfo> dateInfoList = Lists.newLinkedList();
    final int today = 0;
    final int tomorrow = 1;
    final int afterTomorrow = 2;
    final DateTime now = new DateTime(new Date());
    for (int i = 0; i < 9; i++) {
      if (i == today) {
        continue;
      }

      DateTime date = now.plusDays(i);

      dateInfoList.add(
          DateInfo.builder()
              .withDate(date.toString(Globals.DATE_FORMAT_yyyyMMdd))
              .withDay(i == tomorrow ? "明天" : i == afterTomorrow ? "后天" : "")
              .withWeek(i == tomorrow ? 0 : i == afterTomorrow ? 0 : date.getDayOfWeek())
              .build());
    }

    // 2.时间段
    JSONObject json = JSON.parseObject(time == null ? "{}" : time);
    List<TimeBucketInfo> timeBucketInfoList = Lists.newLinkedList();
    for (String start : json.keySet()) {
      String end = json.getString(start);
      timeBucketInfoList.add(
          TimeBucketInfo.builder()
              .withStart(start)
              .withEnd(end)
              .build());
    }

    return new OrderDeliveryDate(dateInfoList, timeBucketInfoList);
  }

  public List<DateInfo> getDateInfo() {
    return dateInfo;
  }

  public void setDateInfo(List<DateInfo> dateInfo) {
    this.dateInfo = dateInfo;
  }

  public List<TimeBucketInfo> getTimeBucketInfo() {
    return timeBucketInfo;
  }

  public void setTimeBucketInfo(List<TimeBucketInfo> timeBucketInfo) {
    this.timeBucketInfo = timeBucketInfo;
  }
}
