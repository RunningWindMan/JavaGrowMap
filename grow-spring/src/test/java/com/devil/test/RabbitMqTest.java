package com.devil.test;

import com.devil.spring.DevilSpringApplication;
import com.devil.spring.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * rabbitmq测试
 *
 * @author Devil
 * @date Created in 2021/12/9 10:39
 */
@SpringBootTest(classes = {DevilSpringApplication.class})
public class RabbitMqTest {
    
    @Autowired
    private RabbitAdmin rabbitAdmin;
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Test
    public void testCreateQueue() {
        // common direct queue
        //        rabbitAdmin.declareQueue(new Queue("devil-test"));
        //        rabbitAdmin.declareBinding(new Binding("devil-test", Binding.DestinationType.QUEUE, "amq.direct", "test", new HashMap()));
        
        // common topic queue
        rabbitAdmin.declareQueue(new Queue("devil-topic-test-all"));
        rabbitAdmin.declareBinding(
                new Binding("devil-topic-test-all", Binding.DestinationType.QUEUE, "amq.topic", "test.topic.#",
                        new HashMap()));
        
        // delayed direct queue
        //        Map<String, Object> args = new HashMap<>();
        //        args.put("x-delayed-type", "direct");
        //        rabbitAdmin.declareExchange(new CustomExchange("devil.exchange.delayed", "x-delayed-message", true, false, args));
        //        rabbitAdmin.declareQueue(new Queue("devil-test-delayed"));
        //        rabbitAdmin.declareBinding(new Binding("devil-test-delayed", Binding.DestinationType.QUEUE, "devil.exchange.delayed", "test-delayed", new HashMap()));
    }
    
    @Test
    public void testDirectMessage() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<>();
            int index = random.nextInt(1000);
            map.put("id", System.currentTimeMillis());
            map.put("time", DateUtil.fastDateTimeFormat(new Date()));
            map.put("name", "devil" + index);
            rabbitTemplate.convertAndSend("amq.direct", "test", map);
        }
    }
    
    @Test
    public void testTopicMessage() {
        Map<String, Object> map = new HashMap<>();
        Random random = new Random();
        int i = random.nextInt(1000);
        map.put("id", System.currentTimeMillis());
        map.put("time", DateUtil.fastDateTimeFormat(new Date()));
        map.put("name", "devil" + i);
        rabbitTemplate.convertAndSend("amq.topic", "test.topic.b", map);
    }
    
    @Test
    public void testDirectDelayedMessage() {
        Map<String, Object> map = new HashMap<>();
        Random random = new Random();
        int i = random.nextInt(1000);
        map.put("id", System.currentTimeMillis());
        map.put("time", DateUtil.fastDateTimeFormat(new Date()));
        map.put("name", "devil" + i);
        rabbitTemplate.convertAndSend("devil.exchange.delayed", "test-delayed", map, message -> {
            // 延迟10秒
            message.getMessageProperties().setDelay(10 * 1000);
            return message;
        });
    }
    
}
