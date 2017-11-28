package com.jshop.repository.order.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jshop.datasource.annotation.DbMsEnum;
import com.jshop.datasource.annotation.SwitchDs;
import com.jshop.mapper.order.OrderOriginalMapper;
import com.jshop.model.builder.EntityWrapperBuilder;
import com.jshop.model.entity.order.OrderOriginalDo;
import com.jshop.repository.order.IOrderOriginalRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2017/9/13.
 */
@Repository
public class OrderOriginalRepositoryImpl
    extends ServiceImpl<OrderOriginalMapper, OrderOriginalDo>
    implements IOrderOriginalRepository<OrderOriginalDo> {
  /**
   * 根据订单编号查询订单原始信息.
   *
   * @param orderId 订单编号
   * @return 订单原始信息实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public OrderOriginalDo queryById(Long orderId) {
    return super.selectById(orderId);
  }

  /**
   * 添加订单原始信息.
   *
   * @param target 订单原始信息实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public void add(OrderOriginalDo target) {
    super.insert(target);
  }

  /**
   * 根据订单主键编号获取订单原始商品数据.
   *
   * @param orderId 订单主键编号
   * @return 订单原始商品数据实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public OrderOriginalDo queryByOrderId(Long orderId) {
    return super.selectOne(
        EntityWrapperBuilder.builder(OrderOriginalDo.class)
            .where("order_id={0}", orderId)
            .getTarget());
  }
}
