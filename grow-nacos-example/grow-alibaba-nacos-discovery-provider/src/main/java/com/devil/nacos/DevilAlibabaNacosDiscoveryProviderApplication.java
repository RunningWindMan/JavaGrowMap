package com.devil.nacos;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * nacos启动类
 *
 * @author devil
 * @version 1.0
 * @date Created in 2022/1/17 14:50
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DevilAlibabaNacosDiscoveryProviderApplication {
    
    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(
                DevilAlibabaNacosDiscoveryProviderApplication.class);
        springApplicationBuilder.run(args);
    }
    
}
