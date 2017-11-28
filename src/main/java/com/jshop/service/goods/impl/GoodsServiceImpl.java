package com.jshop.service.goods.impl;

import com.google.common.collect.Lists;
import com.jshop.model.entity.goods.GoodsDo;
import com.jshop.model.entity.goods.GoodsMasterDo;
import com.jshop.model.query.goods.GoodsSearchQuery;
import com.jshop.model.vo.goods.GoodsSearchVo;
import com.jshop.repository.goods.IGoodsMasterRepository;
import com.jshop.repository.goods.IGoodsRepository;
import com.jshop.service.goods.IGoodsService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Created by yanglikai on 2017/9/8.
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
  @Resource
  private IGoodsRepository goodsRepository;
  @Resource
  private IGoodsMasterRepository goodsMasterRepository;

  /**
   * 商品搜索.
   *
   * @param query 商品搜索参数
   * @return 商品搜索结果实例
   */
  @Override
  public List<GoodsSearchVo> search(GoodsSearchQuery query) {
    if (StringUtils.isEmpty(query.getQ())) {
      return Lists.newArrayListWithCapacity(0);
    }

    List<GoodsDo> goodsDoList = goodsRepository.likeQuery(query);
    if (CollectionUtils.isEmpty(goodsDoList)) {
      return Lists.newArrayList();
    }

    for (GoodsDo goodsDo : goodsDoList) {
      GoodsMasterDo goodsMasterDo = goodsMasterRepository.queryByGoodsCode(goodsDo.getGoodsCode());
      if (goodsMasterDo == null) {
        continue;
      }

    }

    List<GoodsSearchVo> rsp = Lists.newArrayListWithCapacity(goodsDoList.size());
    for (GoodsDo source : goodsDoList) {
      rsp.add(GoodsSearchVo.builder()
          .withCode(source.getGoodsCode())
          .withTitle(source.getGoodsName())
          .withTags(source.getCustomeizeUnit() == null
              ? Lists.newArrayList()
              : source.getCustomeizeUnit().values())
          .build());
    }

    return rsp;
  }
}
