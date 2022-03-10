package com.devil.nacos;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * nacos启动类
 *
 * @author devil
 * @version 1.0
 * @date Created in 2022/1/17 14:50
 */
@SpringBootApplication
public class DevilNacosApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(DevilNacosApplication.class);
        springApplicationBuilder.run(args);
    }

}
