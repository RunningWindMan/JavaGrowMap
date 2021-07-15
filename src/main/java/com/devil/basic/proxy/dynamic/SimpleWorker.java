package com.devil.basic.proxy.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Devil
 * @date Created in 2021/7/15 13:37
 */
public class SimpleWorker implements Worker {

    private static final Logger log = LoggerFactory.getLogger(SimpleWorker.class);

    @Override
    public String work() {
        log.info("工作工作--------");
        return null;
    }

}
