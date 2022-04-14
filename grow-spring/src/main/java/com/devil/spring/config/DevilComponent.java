package com.devil.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * bean
 *
 * @author Devil
 * @date Created in 2021/8/3 13:29
 */
@Component
public class DevilComponent {
    
    private static final Logger log = LoggerFactory.getLogger(DevilComponent.class);
    
    @Bean
    public DevilComponentBean devilComponentBean() {
        log.info("devil component bean config =======");
        return new DevilComponentBean();
    }
    
}
