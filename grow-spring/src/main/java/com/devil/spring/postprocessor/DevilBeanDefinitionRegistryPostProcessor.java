package com.devil.spring.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author Devil
 * @date Created in 2021/7/14 22:43
 */
public class DevilBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    
    private static final Logger log = LoggerFactory.getLogger(DevilBeanDefinitionRegistryPostProcessor.class);
    
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info("postProcessBeanDefinitionRegistry++++++++++");
    }
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("postProcessBeanFactory++++++++++");
    }
}
