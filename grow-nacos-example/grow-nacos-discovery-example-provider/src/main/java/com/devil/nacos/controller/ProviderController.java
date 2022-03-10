package com.devil.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Devil
 * @date Created in 2022/3/10 10:36
 */
@RestController
@RequestMapping(value = "discovery")
public class ProviderController {

    @GetMapping(value = "get")
    public String get() {
        return "devil nacos";
    }

}
