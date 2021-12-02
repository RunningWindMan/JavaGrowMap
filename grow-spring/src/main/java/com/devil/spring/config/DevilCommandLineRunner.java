package com.devil.spring.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Devil
 * @date Created in 2021/9/8 13:54
 */
@Component
public class DevilCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
//        while (true) {
//            System.out.println(System.currentTimeMillis());
//            TimeUnit.MILLISECONDS.sleep(500);
//        }
    }
}
