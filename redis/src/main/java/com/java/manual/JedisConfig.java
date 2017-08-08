package com.java.manual;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * redis 配置
 * Created by Administrator on 2017/8/8 0008.
 */
@Configuration
public class JedisConfig {

    @Bean
    public JedisPool jedisPool(//
                               @Value("${spring.redis.host}") String host, //
                               @Value("${spring.redis.port}") int port) {
        return new JedisPool(host, port);
    }
}
