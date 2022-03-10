package com.devil.nacos;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * nacos启动类
 *
 * @author devil
 * @version 1.0
 * @date Created in 2022/1/17 14:50
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.devil.nacos.clients"})
public class DevilAlibabaNacosDiscoveryConsumerApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(DevilAlibabaNacosDiscoveryConsumerApplication.class);
        springApplicationBuilder.run(args);
    }

}
