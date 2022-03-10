package com.devil.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * nacos配置中心测试样例
 *
 * @author Devil
 * @date Created in 2022/1/17 14:51
 */
@RestController
@RequestMapping(value = "example")
public class ExampleConfigController {

    @NacosValue(value = "${nacos.example.data:1}", autoRefreshed = true)
    private String nacosData;

    @Value("${data:666}")
    private String springData;

    @GetMapping(value = "get")
    public String testGet() {
        return nacosData + "-" + springData;
    }

}
