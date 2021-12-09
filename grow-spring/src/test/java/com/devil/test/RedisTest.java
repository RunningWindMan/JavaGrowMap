package com.devil.test;

import com.devil.spring.DevilSpringApplication;
import com.devil.spring.kafka.KafkaUtil;
import com.devil.spring.redis.RedisUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * kafka测试
 *
 * @author devil
 * @date Created in 2021/7/20 9:19
 */
@SpringBootTest(classes = {DevilSpringApplication.class})
public class RedisTest {

    private static final Logger log = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            redisUtil.zAdd("recommend-" + 11111, i, 10D);
        }
    }

    @Test
    public void test2() {
        redisUtil.zRemove("recommend-" + 11111, "95", "94");
    }

}
 