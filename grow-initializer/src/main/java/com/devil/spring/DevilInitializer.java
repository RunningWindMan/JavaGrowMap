package com.devil.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 初始化测试
 *
 * @author Devil
 * @date Created in 2021/7/20 15:52
 */
public class DevilInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    
    private static final Logger log = LoggerFactory.getLogger(DevilInitializer.class);
    
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("DevilInitializer 进行初始化 ===================");
    }
}
