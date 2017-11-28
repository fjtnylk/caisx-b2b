package com.jshop.config;

import javax.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by yanglikai on 2017/9/5.
 */
@Configuration
@AutoConfigureAfter(RedisProperties.class)
public class RedisConfig {
  @Resource
  private RedisProperties redisProperties;

  /**
   * 初始化redis连接池配置实例.
   *
   * @return redis连接池配置实例
   */
  @Bean
  public JedisPoolConfig jedisPoolConfig() {
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    // 最大连接数
    jedisPoolConfig.setMaxTotal(redisProperties.getMaxTotal());
    // 最大空闲连接数
    jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
    // 在获取连接的时候检查有效性, 默认false
    jedisPoolConfig.setTestOnBorrow(redisProperties.isTestOnBorrow());

    return jedisPoolConfig;
  }

  /**
   * 初始化redis连接池工厂实例.
   *
   * @return redis连接池工厂实例
   */
  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
    jedisConnectionFactory.setHostName(redisProperties.getIp());
    jedisConnectionFactory.setPort(redisProperties.getPort());
    jedisConnectionFactory.setPassword(redisProperties.getPassword());
    jedisConnectionFactory.setPoolConfig(jedisPoolConfig());

    return jedisConnectionFactory;
  }

  /**
   * 初始化redis实例.
   *
   * @return redis实例
   */
  @Bean("redisClient")
  public RedisTemplate redisTemplate() {
    RedisTemplate redisTemplate = new RedisTemplate();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());
    redisTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());

    return redisTemplate;
  }

  /**
   * 初始化字符串Redis操作实例.
   *
   * @return stringRedis实例
   */
  @Bean("stringRedisClient")
  public StringRedisTemplate stringRedisTemplate() {
    StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
    stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
    return stringRedisTemplate;
  }
}
