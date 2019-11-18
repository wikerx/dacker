package com.scott.ds.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName :RedisConfig
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/8/28  17:48
 * @Version :V1.0
 * @Status : 编写
 **/
@Configuration
@EnableCaching
public class RedisConfig {
    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public RedisCacheWriter writer() {
        return RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
    }

    @Bean
    public CacheManager cacheManager() {
        Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
        configurationMap.put("cache1", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)));
        configurationMap.put("cache2", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(2)));

        return RedisCacheManager.builder(writer())
                .initialCacheNames(configurationMap.keySet())
                .withInitialCacheConfigurations(configurationMap)
                .build();
    }
}