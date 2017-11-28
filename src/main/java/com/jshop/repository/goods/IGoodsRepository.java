package com.jshop.repository.goods;

import com.baomidou.mybatisplus.service.IService;
import com.jshop.model.entity.goods.GoodsDo;
import com.jshop.model.query.goods.GoodsSearchQuery;
import java.util.List;

/**
 * Created by yanglikai on 2017/9/8.
 */
public interface IGoodsRepository<T> extends IService<T> {

  /**
   * 模糊查询.
   *
   * @param query 商品搜索参数实例
   * @return 商品集合实例
   */
  List<GoodsDo> likeQuery(GoodsSearchQuery query);

  /**
   * 根据商品编号查询商品.
   *
   * @param code 商品编号
   * @return 商品实例
   */
  GoodsDo queryByCode(String code);
}
