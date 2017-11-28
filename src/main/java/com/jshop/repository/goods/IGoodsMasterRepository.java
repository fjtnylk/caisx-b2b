package com.jshop.repository.goods;

import com.baomidou.mybatisplus.service.IService;
import com.jshop.model.entity.goods.GoodsMasterDo;

/**
 * Created by yanglikai on 2017/9/15.
 */
public interface IGoodsMasterRepository<T> extends IService<T> {

  /**
   * 根据商品编号查询商品主数据.
   *
   * @param goodsCode 商品编号
   * @return 商品主数据实例
   */
  GoodsMasterDo queryByGoodsCode(String goodsCode);
}
