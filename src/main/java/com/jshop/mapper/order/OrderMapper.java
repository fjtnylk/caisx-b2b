package com.jshop.mapper.order;

import com.jshop.mapper.SuperMapper;
import com.jshop.model.entity.order.OrderDo;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yanglikai on 2017/9/6.
 */
public interface OrderMapper extends SuperMapper<OrderDo> {

  /**
   * 更新订单状态为【取消订单】.
   *
   * @param orderId 订单编号
   */
  int update4Cancel(String orderId);

  @Select(value = ""
      + "SELECT "
      + "id AS id,"
      + "user_id AS userId,"
      + "user_name AS userName,"
      + "order_status AS orderStatus,"
      + "goods_info AS goodsInfo,"
      + "order_goods_count AS orderGoodsCount,"
      + "totalPrice,addTime,"
      + "return_goods_info AS returnGoodsInfo,"
      + "receiver_name AS receiverName,"
      + "receiver_area AS receiverArea,"
      + "receiver_area_info AS receiverAreaInfo,"
      + "receiver_mobile AS receiverMobile,"
      + "delivery_time AS deliveryTime,"
      + "user_order_type AS userOrderType,"
      + "msg,"
      + "user_contract_no AS userContractNo,"
      + "order_main AS orderMain,"
      + "bussiness_type AS bussinessType,"
      + "eva_user_id AS evaUserId,"
      + "order_id AS orderId,"
      + "order_type AS orderType,"
      + "contract_store_no AS contractStoreNo,"
      + "target_store_no AS targetStoreNo "
      + "FROM jshop_orderform "
      + "WHERE (user_name=#{userName} and order_main=1) "
      + "ORDER BY addTime DESC "
      + "LIMIT 1")
  OrderDo selectLastOne(String userName);
}
