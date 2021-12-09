package com.devil.spring.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;

/**
 * redis配置（带apollo）
 *
 * @author Devil
 * @date Created in 2019-02-15 14:36
 */
@Component
public class RedisConfig {

    private static final Logger log = LoggerFactory.getLogger(RedisConfig.class);

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.timeout}")
    private long timeout;
    @Value("${spring.redis.lettuce.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.lettuce.pool.min-idle}")
    private int minIdle;
    @Value("${spring.redis.lettuce.pool.max-wait}")
    private long maxWait;
    @Value("${spring.redis.lettuce.pool.max-active}")
    private int maxActive;

    private LettuceConnectionFactory lettuceConnectionFactory;

    @PostConstruct
    private void initFactory() {
        Duration duration = Duration.ofMillis(timeout);
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setDatabase(database);
        redisStandaloneConfiguration.setPassword("");
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWait);
        poolConfig.setMaxTotal(maxActive);
        LettucePoolingClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder()
                .poolConfig(poolConfig)
                .commandTimeout(duration)
                .build();
        lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration, lettuceClientConfiguration);
    }

    @Bean(value = "redisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory() {
        log.info("init redis connection == host: {}, port: {}, database: {}", host, port, database);
        return this.lettuceConnectionFactory;
    }

    @Bean(value = "reactiveRedisConnectionFactory")
    public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
        log.info("init reactive redis connection == host: {}, port: {}, database: {}", host, port, database);
        return this.lettuceConnectionFactory;
    }

    @Bean(value = "redisTemplate")
    @ConditionalOnBean(RedisConnectionFactory.class)
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }


    @Bean(value = "stringRedisTemplate")
    @ConditionalOnBean(RedisConnectionFactory.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        return new StringRedisTemplate(factory);
    }

}
