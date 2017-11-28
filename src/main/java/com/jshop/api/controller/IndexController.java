package com.jshop.api.controller;

import com.jshop.api.ApiResult;
import com.jshop.api.context.UserContext;
import com.jshop.constant.Globals;
import com.jshop.model.vo.IndexLoadVo;
import com.jshop.service.index.IIndexService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2017/9/6.
 */
@RequestMapping(value = "/api")
@RestController
public class IndexController {
  @Resource
  private IIndexService indexService;

  /**
   * 首页.
   *
   * @return 首页展示结果
   */
  @RequestMapping(
      value = "/caisx.index/" + Globals.API_VERSION + "/get",
      method = RequestMethod.GET)
  @ResponseBody
  public ApiResult index() {
    long userId = UserContext.getUserId();
    IndexLoadVo indexLoadVo = indexService.loadIndex(userId);
    return ApiResult.success(indexLoadVo);
  }
}
