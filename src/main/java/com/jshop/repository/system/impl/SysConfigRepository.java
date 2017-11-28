package com.jshop.repository.system.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jshop.constant.RedisKey;
import com.jshop.datasource.annotation.DbMsEnum;
import com.jshop.datasource.annotation.SwitchDs;
import com.jshop.mapper.system.SysConfigMapper;
import com.jshop.model.builder.EntityWrapperBuilder;
import com.jshop.model.entity.SysConfigDo;
import com.jshop.repository.system.ISysConfigRepository;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by yanglikai on 2017/9/14.
 */
@Repository
public class SysConfigRepository
    extends ServiceImpl<SysConfigMapper, SysConfigDo>
    implements ISysConfigRepository<SysConfigDo> {
  @Resource
  private StringRedisTemplate stringRedisClient;

  /**
   * 加载系统配置.
   */
  @SwitchDs(ms = DbMsEnum.JSHOP_COMMON)
  @Override
  public void loadConfig() {
    List<SysConfigDo> sysConfigAll = super.selectList(
        EntityWrapperBuilder.builder(SysConfigDo.class)
            .getTarget());

    for (SysConfigDo sysConfig : sysConfigAll) {
      String key = String.format(RedisKey.B2B_SYS_CONFIG.key, sysConfig.getSysKey());
      stringRedisClient
          .opsForValue()
          .set(
              key,
              sysConfig.getSysValue(),
              RedisKey.B2B_SYS_CONFIG.expired,
              TimeUnit.SECONDS);
    }
  }


  /**
   * 根据key获取value.
   *
   * @param target 目标key
   * @return value
   */
  @Override
  public String getValue(String target) {
    String key = String.format(RedisKey.B2B_SYS_CONFIG.key, target);
    String value = stringRedisClient.opsForValue().get(key);
    if (StringUtils.isEmpty(value)) {
      loadConfig();
      value = stringRedisClient.opsForValue().get(key);
    }

    return value;
  }
}
