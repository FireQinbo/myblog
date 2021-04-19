package com.qb.myblog.config;

import java.time.Duration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author qinb
 * @date 2021/4/6 16:32
 */
@Slf4j
@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
        //自主实现我们的redisTemplate方法。
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        //序列化
        StringRedisSerializer redisSerializer = new StringRedisSerializer();
        //引入json串的转换类
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =
                new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        //redisTemplate设置
        redisTemplate.setConnectionFactory(factory);
        //redis key的序列化
        redisTemplate.setKeySerializer(redisSerializer);
        //value 序列化 使用的是jasonJackson2JsonRedisSerializer。我们的value大部分都是通过对象转化来的
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        //value的序列化 hashmap的序列化
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        //序列化
        StringRedisSerializer redisSerializer = new StringRedisSerializer();
        //引入json串的转换类
        Jackson2JsonRedisSerializer jasonJackson2JsonRedisSerializer =
                new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        //设置我们的objectMapper的访问权限
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jasonJackson2JsonRedisSerializer.setObjectMapper(om);

        //序列化配置，乱码问题解决以及我们的缓存的时效性
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().
                entryTtl(Duration.ofSeconds(60)).
                serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer)).
                serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jasonJackson2JsonRedisSerializer)).
                disableCachingNullValues();

        //RedisCacheManager cacheManager = RedisCacheManager.builder(factory).cacheDefaults(config).build();
        RedisCacheManager cacheManager = RedisCacheManagerBuilder.fromConnectionFactory(factory).cacheDefaults(config).build();

        return cacheManager;
    }
}
