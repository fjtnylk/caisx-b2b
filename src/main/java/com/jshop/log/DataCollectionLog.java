package com.jshop.log;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanglikai on 2017/8/3.
 */
public class DataCollectionLog {
  private static final Logger log = LoggerFactory.getLogger(DataCollectionLog.class);

  public static void log(CollectionValue value) {
    log.info(JSON.toJSONString(value));
  }
}
