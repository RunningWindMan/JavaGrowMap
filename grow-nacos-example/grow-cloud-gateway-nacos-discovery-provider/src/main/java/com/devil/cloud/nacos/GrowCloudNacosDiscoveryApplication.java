package com.devil.cloud.nacos;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Devil
 * @date Created in 2022/3/21 14:12
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GrowCloudNacosDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(GrowCloudNacosDiscoveryApplication.class);
        springApplicationBuilder.run(args);
    }

}
