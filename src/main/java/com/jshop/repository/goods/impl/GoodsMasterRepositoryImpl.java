package com.jshop.repository.goods.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jshop.datasource.annotation.DbMsEnum;
import com.jshop.datasource.annotation.SwitchDs;
import com.jshop.mapper.goods.GoodsMasterMapper;
import com.jshop.model.builder.EntityWrapperBuilder;
import com.jshop.model.entity.goods.GoodsMasterDo;
import com.jshop.repository.goods.IGoodsMasterRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2017/9/15.
 */
@Repository
public class GoodsMasterRepositoryImpl
    extends ServiceImpl<GoodsMasterMapper, GoodsMasterDo>
    implements IGoodsMasterRepository<GoodsMasterDo> {

  /**
   * 根据商品编号查询商品主数据.
   *
   * @param goodsCode 商品编号
   * @return 商品主数据实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public GoodsMasterDo queryByGoodsCode(String goodsCode) {
    return super.selectOne(
        EntityWrapperBuilder.builder(GoodsMasterDo.class)
            .where("good_code={0}", goodsCode)
            .getTarget());
  }
}
