package com.devil.spring;

import com.devil.spring.config.EnableDevilAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Spring启动类
 *
 * @author Devil
 * @date Created in 2021/7/14 21:04
 */
@EnableDevilAutoConfiguration
@SpringBootApplication
public class DevilSpringApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DevilSpringApplication.class).run(args);
    }

}
