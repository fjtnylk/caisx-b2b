package com.jshop.repository.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jshop.datasource.annotation.DbMsEnum;
import com.jshop.datasource.annotation.SwitchDs;
import com.jshop.mapper.user.BaseCustInfoMapper;
import com.jshop.model.builder.EntityWrapperBuilder;
import com.jshop.model.entity.user.BaseCustInfoDo;
import com.jshop.repository.user.IBaseCustInfoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2017/9/6.
 */
@Repository
public class BaseCustInfoRepository
    extends ServiceImpl<BaseCustInfoMapper, BaseCustInfoDo>
    implements IBaseCustInfoRepository<BaseCustInfoDo> {
  /**
   * 根据客户编号查询客户基本信息.
   *
   * @param custNo 客户编号
   * @return 客户基本信息实体
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public BaseCustInfoDo queryByCustNo(String custNo) {
    return super.selectOne(
        EntityWrapperBuilder
            .builder(BaseCustInfoDo.class)
            .where("cust_code={0}", custNo)
            .getTarget());
  }
}
