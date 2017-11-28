package com.jshop.repository.order.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.jshop.constant.RedisKey;
import com.jshop.datasource.annotation.DbMsEnum;
import com.jshop.datasource.annotation.SwitchDs;
import com.jshop.mapper.order.OrderMapper;
import com.jshop.model.builder.EntityWrapperBuilder;
import com.jshop.model.builder.PageBuilder;
import com.jshop.model.entity.order.OrderDo;
import com.jshop.repository.order.IOrderRepository;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2017/9/6.
 */
@Repository
public class OrderRepository
    extends ServiceImpl<OrderMapper, OrderDo> implements IOrderRepository<OrderDo> {
  @Resource
  private OrderMapper orderMapper;
  @Resource
  private StringRedisTemplate stringRedisClient;

  /**
   * 查询用户最近订单.
   *
   * @param userName 用户名
   * @return 用户最近订单集合
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public OrderDo query4LastOrder(String userName) {
    return orderMapper.selectLastOne(userName);
  }

  /**
   * 订单分页.
   *
   * @param userId 用户编号
   * @param page   当前页数
   * @param status 订单状态
   * @return 订单分页实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public List<OrderDo> queryPage(Long userId, Integer page, Integer status) {
    Page<OrderDo> pageList = super.selectPage(
        PageBuilder.builder(OrderDo.class)
            .page(page)
            .getTarget(),
        EntityWrapperBuilder.builder(OrderDo.class)
            .where("user_id={0}", userId.toString())
            .and("order_status={0}", status)
            .and("order_main={0}", 1)
            .orderBy("addTime")
            .getTarget());

    return Lists.newArrayList(pageList.getRecords());
  }

  /**
   * 根据订单编号查询订单.
   *
   * @param orderCode 订单编号
   * @return 订单信息实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public OrderDo queryByCode(String orderCode) {
    return super.selectOne(
        EntityWrapperBuilder.builder(OrderDo.class)
            .where("order_id={0}", orderCode)
            .getTarget());
  }

  /**
   * 根据主键查询订单.
   *
   * @param id 订单编号
   * @return 订单信息实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public OrderDo queryById(Long id) {
    return super.selectById(id);
  }

  /**
   * 取消订单.
   *
   * @param orderId 订单编号
   * @return 受影响行数
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public int update4Cancel(String orderId) {
    return orderMapper.update4Cancel(orderId);
  }

  /**
   * 创建订单.
   *
   * @param target 订单数据
   * @return 订单数据实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public OrderDo insertOrder(OrderDo target) {
    super.insert(target);
    return target;
  }

  /**
   * 自增订单流水编号.
   *
   * @return 自增订单流水编号
   */
  @Override
  public String increment() {
    final long start = 10000L;
    String key = RedisKey.B2B_ORDER_CODE_INCREMENT.key;
    String value = stringRedisClient.opsForValue().get(key);
    if (StringUtils.isEmpty(value)) {
      stringRedisClient.opsForValue().set(key, String.valueOf(start));
      return String.valueOf(start);
    }

    final int incr = 1;
    long incred = stringRedisClient.opsForValue().increment(key, incr);
    return String.valueOf(incred);
  }
}
