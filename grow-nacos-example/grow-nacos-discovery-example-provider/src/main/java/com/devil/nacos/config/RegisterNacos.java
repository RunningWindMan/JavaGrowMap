package com.devil.nacos.config;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * nacos注册
 *
 * @author Devil
 * @date Created in 2022/3/10 11:14
 */
@Component
public class RegisterNacos {
    
    @NacosInjected
    private NamingService namingService;
    
    @Value("${server.port}")
    private int serverPort;
    
    @Value("${spring.application.name}")
    private String applicationName;
    
    /**
     * 注册服务
     *
     * @throws NacosException
     */
    @PostConstruct
    public void registerInstance() throws NacosException {
        namingService.registerInstance(applicationName, "127.0.0.1", serverPort);
    }
    
}