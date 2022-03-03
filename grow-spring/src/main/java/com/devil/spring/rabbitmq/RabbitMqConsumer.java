package com.devil.spring.rabbitmq;

import com.rabbitmq.client.Channel;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * rabbitmq消费者
 *
 * @author Devil
 * @date Created in 2021/12/9 11:29
 */
//@Component
public class RabbitMqConsumer {

    private static final Logger log = LoggerFactory.getLogger(RabbitMqConsumer.class);

    @Autowired
    private RedissonClient redissonClient;

    @RabbitListener(queues = {"devil-test"})
    public void handleCommonDirectMessage(Message message, Channel channel) {
        log.info("收到消息 : {}", new String(message.getBody()));
        // 上带续期锁，队列消息只在一个消费者消费，但不能保证顺序性
        RLock devilTestLock = redissonClient.getLock("devilTestLock");
        try {
            if (devilTestLock.tryLock(10L, 30000L, TimeUnit.MILLISECONDS)) {
                // 采用手动ack，一条条的消费
                log.info("真正处理消息==============================");
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } else {
                // 还可以nack，第三个参数是否重回队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                log.info("没有获取到锁 不处理");
            }
        } catch (InterruptedException e) {
            log.error("获取锁失败", e);
        } catch (IOException e) {
            log.error("队列数据处理失败", e);
        }
    }

    @RabbitListener(queues = {"devil-topic-test"})
    public void handleCommonTopicMessage(Message message, Channel channel) {
        log.info("收到 {} 消息 : {}", message.getMessageProperties().getConsumerQueue(), new String(message.getBody()));
        // 采用手动ack，一条条的消费
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            // 还可以nack，第三个参数是否重回队列
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        } catch (IOException e) {
            log.error("rabbitmq消费失败", e);
        }
    }

    @RabbitListener(queues = {"devil-topic-test-all"})
    public void handleCommonTopicAllMessage(Message message, Channel channel) {
        log.info("收到 {} 消息 : {}", message.getMessageProperties().getConsumerQueue(), new String(message.getBody()));
        // 采用手动ack，一条条的消费
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            // 还可以nack，第三个参数是否重回队列
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        } catch (IOException e) {
            log.error("rabbitmq消费失败", e);
        }
    }

    @RabbitListener(queues = {"devil-test-delayed"})
    public void handleDelayedDirectMessage(Message message, Channel channel) {
        log.info("收到延时消息 : {}", new String(message.getBody()));
        // 采用手动ack，一条条的消费
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            // 还可以nack，第三个参数是否重回队列
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        } catch (IOException e) {
            log.error("rabbitmq消费失败", e);
        }
    }

}
