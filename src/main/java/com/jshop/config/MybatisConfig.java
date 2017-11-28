package com.jshop.config;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.jshop.mapper.SuperMapper;
import com.jshop.typehandler.GoodsInfoListTypeHandler;
import com.jshop.typehandler.GoodsOriginalInfoListTypehandler;
import com.jshop.typehandler.GoodsRefundInfoListTypeHandler;
import com.jshop.typehandler.GoodsUnitTypeHandler;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Configuration
@ConditionalOnClass({EnableTransactionManagement.class})
@AutoConfigureAfter({DatasourceConfig.class})
@MapperScan(
    basePackages = {"com.jshop.mapper"},
    sqlSessionFactoryRef = "sqlSessionFactory",
    markerInterface = SuperMapper.class)
public class MybatisConfig {
  @Resource
  private DataSource dataSource;

  /**
   * 初始化sqlSessionFactory.
   *
   * @return SqlSessionFactory
   */
  @Bean(name = "sqlSessionFactory")
  @ConditionalOnMissingBean
  public SqlSessionFactory sqlSessionFactory() {
    MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage("com.muy.entity");

    // 添加Mybatis自定义配置
    MybatisConfiguration configuration = new MybatisConfiguration();
    configuration.setMapUnderscoreToCamelCase(true);
    sqlSessionFactoryBean.setConfiguration(configuration);

    // 添加mybatisPlus自定义全局配置
    GlobalConfiguration globalConfiguration = new GlobalConfiguration();
    // 主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
    globalConfiguration.setIdType(IdType.ID_WORKER.getKey());
    // 字段策略 0:"忽略判断",1:"非 NULL 判断"),2:"非空判断"
    globalConfiguration.setFieldStrategy(FieldStrategy.NOT_EMPTY.getKey());
    // 驼峰下划线转换
    globalConfiguration.setDbColumnUnderline(true);
    // 刷新mapper 调试神器
    globalConfiguration.setRefresh(true);
    //// 数据库大写下划线转换
    //globalConfiguration.setCapitalMode(true);
    //// 序列接口实现类配置
    //globalConfiguration.setKeyGenerator(null);
    //// 逻辑删除配置
    //globalConfiguration.setLogicDeleteValue("0");
    //globalConfiguration.setLogicNotDeleteValue("1");
    //// 自定义填充策略接口实现
    //globalConfiguration.setMetaObjectHandler(null);
    //// 自定义SQL注入器
    //globalConfiguration.setSqlInjector(null);
    sqlSessionFactoryBean.setGlobalConfig(globalConfiguration);

    // 添加分页插件配置
    sqlSessionFactoryBean.setPlugins(new Interceptor[]{new PaginationInterceptor()});
    // 添加类型插件配置
    sqlSessionFactoryBean.setTypeHandlers(new TypeHandler[]{
        new GoodsUnitTypeHandler(),
        new GoodsInfoListTypeHandler(),
        new GoodsRefundInfoListTypeHandler(),
        new GoodsOriginalInfoListTypehandler()});

    // 添加XML目录
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    try {
      sqlSessionFactoryBean
          .setMapperLocations(
              resolver.getResources("classpath:mapper/*/*Mapper.xml"));
      return sqlSessionFactoryBean.getObject();
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }

  @Bean
  @ConditionalOnMissingBean
  public DataSourceTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource);
  }
}
