package com.devil.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * spring bean集合注入
 *
 * @author Devil
 * @date Created in 2022/3/3 14:09
 */
@Component
public class BeanListInject {
    
    private static final Logger log = LoggerFactory.getLogger(BeanListInject.class);
    
    @Autowired
    private List<BeanListInterface> beanListInterfaceList;
    
    public void work() {
        for (BeanListInterface beanListInterface : beanListInterfaceList) {
            beanListInterface.work();
        }
    }
    
}
