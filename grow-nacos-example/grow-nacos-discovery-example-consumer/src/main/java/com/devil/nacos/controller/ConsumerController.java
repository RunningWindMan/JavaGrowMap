package com.devil.nacos.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Devil
 * @date Created in 2022/3/10 12:02
 */
@RestController
@RequestMapping(value = "consumer")
public class ConsumerController {

    private static final Logger log = LoggerFactory.getLogger(ConsumerController.class);

    @NacosInjected
    private NamingService namingService;

    @GetMapping(value = "get")
    public String get() {
        try {
            List<Instance> instances = namingService.getAllInstances("grow-nacos-discovery-provider", "DEFAULT_GROUP");
            instances.forEach(e -> log.info(e.toString()));
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
