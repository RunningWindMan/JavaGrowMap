package com.devil.nacos.controller;

import com.devil.nacos.clients.ProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Devil
 * @date Created in 2022/3/10 15:34
 */
@RestController
@RequestMapping(value = "consumer")
public class ConsumerController {
    
    @Autowired
    private ProviderFeignClient providerFeignClient;
    
    @GetMapping(value = "get")
    public String get() {
        return providerFeignClient.get();
    }
    
}
