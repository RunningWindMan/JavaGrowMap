package com.devil.spring.postprocessor;

import com.devil.spring.bean.DevilBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.Ordered;

/**
 * @author Devil
 * @date Created in 2021/7/14 21:16
 */
public class DevilPostProcessor implements BeanPostProcessor, Ordered, BeanFactoryAware {

    private static final Logger log = LoggerFactory.getLogger(DevilPostProcessor.class);

    private BeanFactory beanFactory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DevilBean) {
            log.info("bean初始化前===========   beanName : {}", beanName);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DevilBean) {
            log.info("bean初始化后-----  beanName : {}", beanName);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}
