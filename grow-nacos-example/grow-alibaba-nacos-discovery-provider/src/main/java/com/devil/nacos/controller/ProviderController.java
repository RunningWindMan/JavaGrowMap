package com.devil.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Devil
 * @date Created in 2022/3/10 15:06
 */
@RestController
@RequestMapping(value = "provider")
public class ProviderController {
    
    private static final Logger log = LoggerFactory.getLogger(ProviderController.class);
    
    @GetMapping(value = "get")
    public String get() {
        log.info("devil nacos yes");
        return "nacos discovery get";
    }
    
}
