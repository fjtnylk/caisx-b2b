package com.jshop.repository.system;

import com.baomidou.mybatisplus.service.IService;

/**
 * Created by yanglikai on 2017/9/14.
 */
public interface ISysConfigRepository<T> extends IService<T> {

  /**
   * 加载系统配置.
   *
   */
  void loadConfig();

  /**
   * 根据key获取value.
   *
   * @param target 目标key
   * @return value
   */
  String getValue(String target);
}
