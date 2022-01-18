package com.devil.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * 执行结果:
 * DevilBean no arg Construct
 * bean初始化前===========   beanName : devilBean
 * DevilBean postConstruct
 * DevilBean afterPropertiesSet
 * DevilBean init
 * bean初始化后-----  beanName : devilBean
 *
 * @author Devil
 * @date Created in 2021/7/15 9:47
 */
public class DevilBean implements InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(DevilBean.class);

    private int count;

    public DevilBean() {
        log.info("DevilBean no arg Construct");
    }

    public void init() {
        log.info("DevilBean init");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("DevilBean postConstruct");
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count : the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("DevilBean afterPropertiesSet");
    }
}
