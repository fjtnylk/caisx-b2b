package com.jshop.repository.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jshop.datasource.annotation.DbMsEnum;
import com.jshop.datasource.annotation.SwitchDs;
import com.jshop.mapper.user.CreditCustInfoMapper;
import com.jshop.model.builder.EntityWrapperBuilder;
import com.jshop.model.entity.user.CreditCustInfoDo;
import com.jshop.repository.user.ICreditCustInfoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2017/9/6.
 */
@Repository
public class CreditCustInfoRepository
    extends ServiceImpl<CreditCustInfoMapper, CreditCustInfoDo>
    implements ICreditCustInfoRepository<CreditCustInfoDo> {
  /**
   * 根据客户编号查询信控信息.
   *
   * @param custNo 客户编号
   * @return 信控信息实体
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public CreditCustInfoDo queryByCustNo(String custNo) {
    return super.selectOne(
        EntityWrapperBuilder
            .builder(CreditCustInfoDo.class)
            .where("cust_no={0}", custNo)
            .getTarget());
  }
}
