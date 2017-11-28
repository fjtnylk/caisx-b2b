package com.jshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Configuration
@ComponentScan(value = "com.jshop")
@Import({DatasourceConfig.class, RedisConfig.class, MybatisConfig.class, SpringMvcConfig.class})
public class AppConfig {
}
