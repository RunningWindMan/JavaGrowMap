package com.devil.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * SampleBBeanList
 *
 * @author Devil
 * @date Created in 2022/3/3 14:11
 */
@Component
public class SampleBBeanList implements BeanListInterface, Ordered {
    
    private static final Logger log = LoggerFactory.getLogger(SampleBBeanList.class);
    
    @Override
    public void work() {
        log.info(">>>>>>>>>>  SampleBBeanList");
    }
    
    @Override
    public int getOrder() {
        return -2;
    }
}
