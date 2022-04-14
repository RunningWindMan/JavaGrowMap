package com.devil.spring.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author Devil
 * @date Created in 2021/7/28 10:13
 */
public class DevilBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    
    private static final Logger log = LoggerFactory.getLogger(DevilBeanFactoryPostProcessor.class);
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("postProcessBeanFactory++++++++++");
    }
}
