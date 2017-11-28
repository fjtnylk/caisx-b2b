package com.jshop.repository.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jshop.datasource.annotation.DbMsEnum;
import com.jshop.datasource.annotation.SwitchDs;
import com.jshop.mapper.user.UserTargetStoreMapper;
import com.jshop.model.builder.EntityWrapperBuilder;
import com.jshop.model.entity.user.UserTargetStoreDo;
import com.jshop.repository.user.IUserTargetStoreRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2017/9/19.
 */
@Repository
public class UserTargetStoreRepository
    extends ServiceImpl<UserTargetStoreMapper, UserTargetStoreDo>
    implements IUserTargetStoreRepository<UserTargetStoreDo> {
  /**
   * 根据用户名获取用户签约信息.
   *
   * @param userId 用户编号
   * @return 用户签约信息实例
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public UserTargetStoreDo queryByUserId(Long userId) {
    return super.selectOne(
        EntityWrapperBuilder.builder(UserTargetStoreDo.class)
            .where("user_id={0}", userId)
            .getTarget());
  }
}
