package com.jshop.repository.goods.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.jshop.constant.Globals;
import com.jshop.datasource.annotation.DbMsEnum;
import com.jshop.datasource.annotation.SwitchDs;
import com.jshop.mapper.goods.GoodsMapper;
import com.jshop.model.builder.EntityWrapperBuilder;
import com.jshop.model.builder.PageBuilder;
import com.jshop.model.entity.goods.GoodsDo;
import com.jshop.model.query.goods.GoodsSearchQuery;
import com.jshop.repository.goods.IGoodsRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2017/9/8.
 */
@Repository
public class GoodsRepository
    extends ServiceImpl<GoodsMapper, GoodsDo> implements IGoodsRepository<GoodsDo> {
  /**
   * 模糊查询.
   *
   * @param query 商品搜索参数实例
   * @return 商品集合实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public List<GoodsDo> likeQuery(GoodsSearchQuery query) {
    Page<GoodsDo> page = super.selectPage(
        PageBuilder.builder(GoodsDo.class)
            .page(query.getPage() == null ? 1 : query.getPage())
            .size(Globals.DEFAULT_GOODS_PAGE_ROWS)
            .getTarget(),
        EntityWrapperBuilder.builder(GoodsDo.class)
            .and("goods_status={0}", "0")
            .like("goods_name", query.getQ())
            .getTarget());

    return page == null ? Lists.newArrayListWithCapacity(0) : page.getRecords();
  }

  /**
   * 根据商品编号查询商品.
   *
   * @param code 商品编号
   * @return 商品实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public GoodsDo queryByCode(String code) {
    return super.selectOne(
        EntityWrapperBuilder
            .builder(GoodsDo.class)
            .where("goods_code={0}", code)
            .getTarget());
  }
}
