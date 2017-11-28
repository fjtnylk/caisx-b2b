package com.jshop.service.index.impl;

import com.jshop.api.context.UserContext;
import com.jshop.model.vo.IndexLoadVo;
import com.jshop.model.vo.order.OrderListVo;
import com.jshop.model.vo.user.UserIndexVo;
import com.jshop.service.index.IIndexService;
import com.jshop.service.order.IOrderService;
import com.jshop.service.user.IUserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikai on 2017/9/6.
 */
@Service
public class IndexServiceImpl implements IIndexService {
  @Resource
  private IUserService userService;
  @Resource
  private IOrderService orderService;

  /**
   * 加载首页信息.
   *
   * @param userId 用户编号
   * @return 首页信息实例
   */
  @Override
  public IndexLoadVo loadIndex(Long userId) {
    // 1.用户信息
    UserIndexVo user = userService.loadUserIndex(userId);
    // 2.最近订单
    List<OrderListVo> lastOrder = orderService.loadLastOrder(UserContext.getUserName());
    return IndexLoadVo.builder()
        .withServiceTel(user.getCustServiceTel())
        .withLastOrder(lastOrder)
        .withUser(user)
        .build();
  }
}
