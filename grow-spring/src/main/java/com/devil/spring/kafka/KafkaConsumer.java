package com.devil.spring.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka消费者
 *
 * @author Devil
 * @date Created in 2021/12/2 17:25
 */
//@Component
public class KafkaConsumer {
    
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
    
    /**
     * 消费者示例demo
     * <p>
     * 基于注解监听多个topic，消费topic中消息 （注意：如果监听的topic不存在则会自动创建）
     */
    @KafkaListener(topics = {"test"})
    public void consume(String message) {
        log.info("收到kafka消息 msg: " + message);
    }
    
}
