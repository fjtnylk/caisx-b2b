package com.jshop.service.index;

import com.jshop.model.vo.IndexLoadVo;

/**
 * Created by yanglikai on 2017/9/6.
 */
public interface IIndexService {

  /**
   * 加载首页信息.
   *
   * @param userId 用户编号
   * @return 首页信息实例
   */
  IndexLoadVo loadIndex(Long userId);
}
