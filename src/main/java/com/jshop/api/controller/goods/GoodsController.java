package com.jshop.api.controller.goods;

import com.jshop.api.ApiResult;
import com.jshop.constant.Globals;
import com.jshop.model.query.goods.GoodsSearchQuery;
import com.jshop.service.goods.IGoodsService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2017/9/8.
 */
@RequestMapping(value = "/api")
@RestController
public class GoodsController {
  @Resource
  private IGoodsService goodsService;

  /**
   * 商品搜索.
   *
   * @param query 搜索条件
   * @return 接口返回结果
   */
  @RequestMapping(
      value = "/caisx.goods.search/" + Globals.API_VERSION + "/query",
      method = RequestMethod.GET)
  @ResponseBody
  public ApiResult search(GoodsSearchQuery query) {
    return ApiResult.success(goodsService.search(query));
  }
}
