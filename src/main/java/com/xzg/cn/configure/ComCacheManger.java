//package com.xzg.cn.configure;
//
//import org.springframework.boot.autoconfigure.AutoConfigureOrder;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.cache.support.CompositeCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)//设置加载优先级
//@Configuration
//@EnableCaching
////混合ehcache和redis缓存两种根据顺序查找
//public class ComCacheManger {
//
//    @Bean
//    public CacheManager cacheManager(JedisConnectionFactory redisConnectionFactory,EhCacheCacheManager ehCacheCacheManager){
//        CompositeCacheManager cacheManager = new CompositeCacheManager();
//        List<CacheManager> managers = new ArrayList<>();
//        managers.add(RedisCacheManager.create(redisConnectionFactory));
//        managers.add(ehCacheCacheManager);
//        cacheManager.setCacheManagers(managers);
//        return cacheManager;
//    }
//
//   /* @Bean
//    public RedisTemplate redisTemplate() {
//        StringRedisTemplate redisTemplate = new StringRedisTemplate(jedisConnectionFactory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }*/
//}
