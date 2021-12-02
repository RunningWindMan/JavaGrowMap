package com.devil.test;

import com.devil.spring.DevilSpringApplication;
import com.devil.spring.kafka.KafkaUtil;
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
public class KafkaTest {

    private static final Logger log = LoggerFactory.getLogger(KafkaTest.class);

    @Autowired
    private KafkaUtil kafkaUtil;

    @Test
    public void test1() {
        kafkaUtil.send("test", "4444444444");
    }

}
 