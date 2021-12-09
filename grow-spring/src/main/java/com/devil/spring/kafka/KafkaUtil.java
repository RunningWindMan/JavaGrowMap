package com.devil.spring.kafka;

import com.google.gson.Gson;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * kafka util
 *
 * @author Devil
 * @date Created in 2021/11/22 14:10
 */
//@Component
public class KafkaUtil {

    private static final Logger log = LoggerFactory.getLogger(KafkaUtil.class);

    @Value("${spring.kafka.bootstrap-servers}")
    private String springKafkaBootstrapServers;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private AdminClient adminClient;

    @PostConstruct
    private void initAdminClient() {
        Map<String, Object> props = new HashMap<>();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, springKafkaBootstrapServers);
        adminClient = KafkaAdminClient.create(props);
    }

    public void send(String topic, Object obj) {
        String obj2String = new Gson().toJson(obj);
        // 发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, obj2String);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                // 发送失败的处理
                log.error(topic + " - 生产者 发送消息失败：" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                // 成功的处理
            }
        });
    }

    /**
     * 删除topic，支持批量
     */
    public void deleteTopic(Collection<String> topics) {
        adminClient.deleteTopics(topics);
    }

}
