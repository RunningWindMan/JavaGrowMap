package com.devil.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * SampleABeanList
 *
 * @author Devil
 * @date Created in 2022/3/3 14:11
 */
@Component
public class SampleABeanList implements BeanListInterface {

    private static final Logger log = LoggerFactory.getLogger(SampleABeanList.class);

    @Override
    public void work() {
        log.info(">>>>>>>>>>  SampleABeanList");
    }
}
