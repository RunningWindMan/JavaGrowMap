package com.devil.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试prototype
 *
 * @author Devil
 * @date Created in 2021/7/20 14:07
 */
public class PrototypeBean {
    
    private static final Logger log = LoggerFactory.getLogger(PrototypeBean.class);
    
    private int code;
    
    public PrototypeBean(int code) {
        log.info("初始化bean, code:{}", code);
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
    
}
