package com.devil.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Devil
 * @date Created in 2021/7/20 16:08
 */
public class DevilListener implements ApplicationListener<ApplicationEvent> {
    
    private static final Logger log = LoggerFactory.getLogger(DevilListener.class);
    
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("DevilListener 执行 ---------------------- 事件类型： {}", event);
    }
}
