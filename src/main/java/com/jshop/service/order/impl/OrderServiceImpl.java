package com.jshop.service.order.impl;

import com.google.common.collect.Lists;
import com.jshop.api.context.RequestContext;
import com.jshop.api.context.UserContext;
import com.jshop.biz.IOrderBiz;
import com.jshop.constant.Globals;
import com.jshop.constant.OrderStatus;
import com.jshop.constant.StatusCode;
import com.jshop.exception.order.OrderServiceException;
import com.jshop.model.domain.CodeName;
import com.jshop.model.domain.GoodsInfo;
import com.jshop.model.domain.GoodsInfoList;
import com.jshop.model.domain.GoodsOriginalInfo;
import com.jshop.model.domain.GoodsOriginalInfoList;
import com.jshop.model.domain.GoodsRefundInfoList;
import com.jshop.model.domain.OrderDeliveryAddr;
import com.jshop.model.domain.OrderDeliveryDate;
import com.jshop.model.domain.OrderGoods;
import com.jshop.model.entity.goods.GoodsDo;
import com.jshop.model.entity.goods.GoodsMasterDo;
import com.jshop.model.entity.order.OrderDo;
import com.jshop.model.entity.order.OrderOriginalDo;
import com.jshop.model.entity.user.AddressInfoDo;
import com.jshop.model.entity.user.UserDo;
import com.jshop.model.entity.user.UserTargetStoreDo;
import com.jshop.model.query.order.OrderCreateQuery;
import com.jshop.model.vo.goods.GoodsDtlVo;
import com.jshop.model.vo.goods.GoodsInfoVo;
import com.jshop.model.vo.order.OrderCreateVo;
import com.jshop.model.vo.order.OrderDtlTopVo;
import com.jshop.model.vo.order.OrderDtlVo;
import com.jshop.model.vo.order.OrderExtVo;
import com.jshop.model.vo.order.OrderInitVo;
import com.jshop.model.vo.order.OrderListVo;
import com.jshop.repository.goods.IGoodsMasterRepository;
import com.jshop.repository.goods.IGoodsRepository;
import com.jshop.repository.order.IOrderOriginalRepository;
import com.jshop.repository.order.IOrderRepository;
import com.jshop.repository.user.IAddressInfoRepository;
import com.jshop.repository.user.IUserRepository;
import com.jshop.repository.user.IUserTargetStoreRepository;
import com.jshop.service.order.IOrderService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Created by yanglikai on 2017/9/6.
 */
@Service
public class OrderServiceImpl implements IOrderService {
  private static final String ORDER_EXT_DESC = "拣货称重中,出库后更新金额";

  @Resource
  private IOrderRepository orderRepository;
  @Resource
  private IOrderOriginalRepository orderOriginalRepository;
  @Resource
  private IUserRepository userRepository;
  @Resource
  private IGoodsRepository goodsRepository;
  @Resource
  private IGoodsMasterRepository goodsMasterRepository;
  @Resource
  private IAddressInfoRepository addressInfoRepository;
  @Resource
  private IUserTargetStoreRepository userTargetStoreRepository;
  @Resource
  private IOrderBiz orderBiz;

  /**
   * 加载用户最近订单信息.
   *
   * @param userName 用户名
   * @return 用户最近订单信息集合
   */
  @Override
  public List<OrderListVo> loadLastOrder(String userName) {
    OrderDo order = orderRepository.query4LastOrder(userName);
    if (order == null) {
      return Lists.newArrayList();
    }

    return Lists.newArrayList(
        OrderListVo.builder()
            .parseFrom(order)
            .build());
  }

  /**
   * 加载订单全部信息.
   *
   * @param userId 用户编号
   * @param page   当前页数
   * @return 全部订单信息实例
   */
  @Override
  public List<OrderListVo> loadList4All(Long userId, Integer page) {
    return _loadPage(userId, page, OrderStatus.ALL.code());
  }

  /**
   * 加载待接单信息.
   *
   * @param userId 用户编号
   * @param page   当前页数
   * @return 待接单信息实例
   */
  @Override
  public List<OrderListVo> loadList4Receiving(Long userId, Integer page) {
    return _loadPage(userId, page, OrderStatus.RECEIVING_10.code());
  }

  /**
   * 加载配送中订单信息.
   *
   * @param userId 用户编号
   * @param page   当前页数
   * @return 配送中订单信息实例
   */
  @Override
  public List<OrderListVo> loadList4Delivering(Long userId, Integer page) {
    return _loadPage(userId, page, OrderStatus.DELIVERING_20.code());
  }

  /**
   * 加载订单详情.
   *
   * @param orderCode 订单编号
   * @return 订单详情实例
   */
  @Override
  public OrderDtlVo loadDtl(Long orderCode) {
    OrderDo order = orderRepository.queryByCode(orderCode.toString());
    if (order == null) {
      return OrderDtlVo.empty();
    }

    // 1.订单详情-顶部数据
    // 1.1.顶部数据-订单基础数据
    OrderListVo orderProfile = OrderListVo.builder()
        .parseFrom(order)
        .build();
    // 1.2.顶部数据-订单扩展数据
    OrderExtVo orderExt = OrderExtVo.builder()
        .withDesc(ORDER_EXT_DESC)
        .withRemark(order.getMsg() == null ? "" : order.getMsg())
        .withOrderTypeName(order.getUserOrderType() == null ? "" : order.getUserOrderType())
        .withTotalAmount(order.getTotalPrice().doubleValue())
        .withDeliveryDate(order.getDeliveryTime())
        .withDeliveryAddr(order.getReceiverAreaInfo())
        .build();
    // 1.3.构造顶部数据
    final OrderDtlTopVo orderTop = OrderDtlTopVo.builder()
        .withOrderProfile(orderProfile)
        .withOrderExt(orderExt)
        .build();
    // 2.商品详情数据
    // 2.1.商品详情
    GoodsInfoList goodsInfoList = order.getGoodsInfo();
    GoodsRefundInfoList goodsRefundInfoList = order.getReturnGoodsInfo();
    // 2.2.合并子订单商品数据
    if (order.hasSubOrder() == true) {
      OrderDo subOrder = orderRepository.queryByCode(order.getOrderId().concat("1"));

      goodsInfoList.merge(
          subOrder == null
              ? GoodsInfoList.empty()
              : subOrder.getGoodsInfo());
      goodsRefundInfoList.merge(
          subOrder == null
              ? GoodsRefundInfoList.empty()
              : subOrder.getReturnGoodsInfo());
    }
    // 2.4.构造商品清单
    List<GoodsInfo> goodsList = goodsInfoList.getGoodsInfos();
    List<GoodsInfoVo> goodsDtlVoList = Lists.newArrayListWithCapacity(goodsList.size());
    for (GoodsInfo goods : goodsList) {
      final String orderUnit = goods.getCustomerize_unit_name();
      final String goodsUnit = goods.getOld_unit();
      GoodsInfoVo target = GoodsInfoVo.builder()
          .withName(goods.getGoods_name() == null ? "" : goods.getGoods_name())
          .withBuyCount(
              goods.getGoods_count() == null
                  ? "0".concat(orderUnit)
                  : goods.getGoods_count().concat(orderUnit))
          .withConfirmCount(
              goods.getConfirm_count() == null
                  ? "0".concat(goodsUnit)
                  : goods.getConfirm_count().concat(goodsUnit))
          .withOutCount(
              goods.getOut_count() == null
                  ? "0".concat(goodsUnit)
                  : goods.getOut_count().concat(goodsUnit))
          .withRefundCount(
              goodsRefundInfoList.containsCount(goods.getGoods_code()).concat(goodsUnit))
          .build();

      goodsDtlVoList.add(target);
    }

    /**
     * 待接单状态：
     * 已取消状态：
     *  下单商品如果不是商品主数据也需要显示在详情列表中
     * 待发货状态：
     * 配送中状态：
     * 已收货状态：
     * 已退货状态：
     *  商品详情中只显示确认后的商品主数据
     */
    if (OrderStatus.RECEIVING_10.code() == order.getOrderStatus()
        || OrderStatus.CANCEL_0.code() == order.getOrderStatus()) {
      OrderOriginalDo orderOriginalDo = orderOriginalRepository.queryByOrderId(order.getId());
      List<GoodsOriginalInfo> goodsOriginalInfos =
          orderOriginalDo.getGoodsInfo().getGoodsOriginalInfos();
      for (GoodsOriginalInfo goodsOriginal : goodsOriginalInfos) {
        if (StringUtils.isNotEmpty(goodsOriginal.getCode())) {
          continue;
        }

        final String orderUnit = goodsOriginal.getOrderUnit();
        final String goodsUnit = goodsOriginal.getGoodsUnit();
        GoodsInfoVo target = GoodsInfoVo.builder()
            .withName(goodsOriginal.getName())
            .withBuyCount(goodsOriginal.getCount().concat(orderUnit))
            .withConfirmCount("0".concat(goodsUnit))
            .withOutCount("0".concat(goodsUnit))
            .withRefundCount("0".concat(goodsUnit))
            .build();

        goodsDtlVoList.add(target);
      }
    }

    GoodsDtlVo goodsDtl = GoodsDtlVo.builder()
        .withCount(order.getOrderGoodsCount())
        .withDtl(goodsDtlVoList)
        .build();


    return OrderDtlVo.builder()
        .withTop(orderTop)
        .withGoodsDtl(goodsDtl)
        .build();
  }

  /**
   * 取消订单.
   *
   * @param orderCode 订单编号
   */
  @Override
  public void cancel(String orderCode) {
    orderRepository.update4Cancel(orderCode);
  }

  /**
   * 下单页面初始化数据.
   *
   * @param userId 用户编号
   * @return 初始化数据实例
   */
  @Override
  public OrderInitVo init(Long userId) {
    UserDo user = userRepository.queryUser(userId);
    if (user == null) {
      return OrderInitVo.empty();
    }

    // 1.配送地址
    AddressInfoDo addressInfo = addressInfoRepository.queryByCustCode(
        user.isSub()
            ? user.getContractStoreNo()
            : user.getUserContractNo());
    OrderDeliveryAddr deliveryAddr = OrderDeliveryAddr.builder()
        .withProv("")
        .withCity("")
        .withDistrict("")
        .withStreet(addressInfo == null ? "" : addressInfo.getRelAddr())
        .build();
    // 2.配送日期
    OrderDeliveryDate deliveryDate = OrderDeliveryDate.builder(user.getReceiveTime());
    // 3.订单类型
    List<CodeName> orderType = CodeName.builderList(
        user.getUserOrderType() == null
            ? ""
            : user.getUserOrderType());

    return OrderInitVo.builder()
        .withDeliveryAddr(deliveryAddr)
        .withDeliveryDate(deliveryDate)
        .withOrderType(orderType)
        .build();
  }

  /**
   * 创建订单.
   *
   * @param query 订单数据
   * @return 订单编号
   * @throws OrderServiceException 订单异常
   */
  @Override
  public OrderCreateVo create(OrderCreateQuery query) throws OrderServiceException {
    long userId = UserContext.getUserId();
    UserDo user = userRepository.queryUser(userId);
    if (user == null) {
      return OrderCreateVo.empty();
    }

    // 1.构造商品详情
    GoodsInfoList goodsInfoList = GoodsInfoList.builder().build();
    GoodsOriginalInfoList originalGoodsInfoList = GoodsOriginalInfoList.builder().build();
    for (OrderGoods orderGoods : query.getGoods()) {
      // 1.1获取单个商品信息
      String code = orderGoods.getCode();
      String name = orderGoods.getName() == null ? "" : orderGoods.getName();
      GoodsDo goodsDo = goodsRepository.queryByCode(code);
      GoodsMasterDo goodsMasterDo = goodsMasterRepository.queryByGoodsCode(code);
      // 1.2.构造订单商品扩展信息
      goodsInfoList.add(
          GoodsInfo.builder()
              .withId(goodsDo == null ? 0L : goodsDo.getId())
              .withGoodsCode(code)
              .withGoodsName(name)
              .withBarCode(goodsMasterDo == null ? "" : goodsMasterDo.getBarcode())
              .withGoodsCount(orderGoods.getCount())
              .withOrderUnit(orderGoods.getUnit())
              .withGoodsUnit(goodsMasterDo == null ? orderGoods.getUnit() : goodsMasterDo.getUnit())
              .withSapCategoryNo(goodsMasterDo == null ? "" : goodsMasterDo.getSortId())
              .withOriginalPrice(BigDecimal.ZERO)
              .withSalePrice(BigDecimal.ZERO)
              .withConfirmCount(orderGoods.getCount())
              .build());
      // 1.3构造订单商品原始信息
      originalGoodsInfoList.add(
          GoodsOriginalInfo.builder()
              .withCode(code)
              .withName(name)
              .withBarcode(goodsMasterDo == null ? "" : goodsMasterDo.getBarcode())
              .withOrderUnit(orderGoods.getUnit())
              .withGoodsUnit(goodsMasterDo == null ? orderGoods.getUnit() : goodsMasterDo.getUnit())
              .withCount(orderGoods.getCount())
              .withOriginalPrice(BigDecimal.ZERO)
              .withSalePrice(BigDecimal.ZERO)
              .withSmallCategoryCode(goodsMasterDo == null ? "" : goodsMasterDo.getSortId())
              .build());
    }
    // 2.获取用户履约信息
    // 2.1.如果当前用户为子账户的场合获取主账号的履约信息
    if (user.isSub() == true) {
      String subUserName = user.getContractStoreNo();
      UserDo subUser = userRepository.queryUser(subUserName);
      userId = subUser == null ? userId : subUser.getId();
    }
    UserTargetStoreDo userTargetStoreDo = userTargetStoreRepository.queryByUserId(userId);
    if (userTargetStoreDo == null) {
      throw new OrderServiceException(StatusCode.CODE_54001.code(), StatusCode.CODE_54001.msg());
    }

    /**
     * 生成订单编号.：
     * 规则：
     *  履约门店编号+年月日时间搓+五位流水号
     */
    String orderCode = userTargetStoreDo.getContractStoreNo()
        .concat(new DateTime().toString(Globals.DATE_FORMAT_yyyyMMdd_NONE))
        .concat(orderRepository.increment());

    // 3.提交订单
    String orderId = orderBiz.submit(
        OrderDo.builder()
            .withUserId(userId)
            .withUserName(UserContext.getUserName())
            .withMobile(UserContext.getMobile())
            .withStatus(OrderStatus.RECEIVING_10.code())
            .withDeliveryAddr(query.getDeliveryAddr())
            .withDeliveryDate(query.getDeliveryDate())
            .withTotalCount(query.getTotalCount())
            .withCnee(user.getTrueName())
            .withCreateTime(new Date())
            .withGoodsInfo(goodsInfoList)
            .withTotalAmount(BigDecimal.ZERO)
            .withOrderType(query.getOrderType().getName())
            .withRemark(query.getRemark())
            .withCustNo(user.getUserContractNo())
            .withOrderMain(1)
            .withBizType(0)
            .withFactoryId(user.getStoreId())
            .withOrderCode(orderCode)
            .withChannel(RequestContext.getContext().getChannel())
            .withContractStoreNo(userTargetStoreDo.getContractStoreNo())
            .withTargetStoreNo(userTargetStoreDo.getTargetStoreNo())
            .build(),
        OrderOriginalDo.builder()
            .withGoodsInfo(originalGoodsInfoList)
            .build());

    return OrderCreateVo.builder()
        .withOrderCode(orderId)
        .build();
  }

  /**
   * 分页加载.
   *
   * @param userId 用户编号
   * @param page   当前页数
   * @param status 订单状态
   * @return 分页实例
   */
  private List<OrderListVo> _loadPage(Long userId, Integer page, Integer status) {
    List<OrderDo> orderListDoList = orderRepository.queryPage(userId, page, status);
    if (CollectionUtils.isEmpty(orderListDoList)) {
      return Lists.newArrayList();
    }

    List<OrderListVo> target = Lists.newArrayListWithCapacity(orderListDoList.size());
    for (OrderDo order : orderListDoList) {
      target.add(OrderListVo.builder()
          .parseFrom(order)
          .build());
    }

    return target;
  }
}
