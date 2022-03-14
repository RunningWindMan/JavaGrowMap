package com.devil.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Devil
 * @date Created in 2022/3/14 14:19
 */
@Service
public class ThreadPoolService {

    private static final Logger log = LoggerFactory.getLogger(ThreadPoolService.class);

    @Async(value = "devilThreadPoolTaskExecutor")
    public void asyncTest() {
        log.info("devil =====================================");
    }

}
