package com.devil.basic.proxy.notdynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Devil
 * @date Created in 2021/7/15 11:58
 */
public class TestDomain implements Domain {

    private static final Logger log = LoggerFactory.getLogger(TestDomain.class);

    @Override
    public String get() {
        log.info("test -- == ++");
        return null;
    }

}
