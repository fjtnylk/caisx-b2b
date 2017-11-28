package com.jshop.service.goods;

import com.jshop.model.query.goods.GoodsSearchQuery;
import com.jshop.model.vo.goods.GoodsSearchVo;
import java.util.List;

/**
 * Created by yanglikai on 2017/9/8.
 */
public interface IGoodsService {
  /**
   * 商品搜索.
   *
   * @param query 商品搜索参数
   * @return 商品搜索结果实例
   */
  List<GoodsSearchVo> search(GoodsSearchQuery query);
}
