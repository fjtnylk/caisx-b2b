package com.jshop.repository.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jshop.datasource.annotation.DbMsEnum;
import com.jshop.datasource.annotation.SwitchDs;
import com.jshop.mapper.user.AddressInfoMapper;
import com.jshop.model.builder.EntityWrapperBuilder;
import com.jshop.model.entity.user.AddressInfoDo;
import com.jshop.repository.user.IAddressInfoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2017/9/14.
 */
@Repository
public class AddressInfoRepositoryImpl
    extends ServiceImpl<AddressInfoMapper, AddressInfoDo>
    implements IAddressInfoRepository<AddressInfoDo> {
  /**
   * 根据客户编号获取用户地址信息.
   *
   * @param custCode 客户编号
   * @return 用户地址信息实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public AddressInfoDo queryByCustCode(String custCode) {
    return super.selectOne(
        EntityWrapperBuilder.builder(AddressInfoDo.class)
            .where("cust_code={0}", custCode)
            .getTarget());
  }
}
