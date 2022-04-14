package com.devil.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * oom接口测试 （一个接口oom不会影响其他接口）
 *
 * @author Devil
 * @date Created in 2021/7/28 10:28
 */
@RestController
@RequestMapping(path = "oomTest")
public class OomTestController {
    
    private static final Logger log = LoggerFactory.getLogger(OomTestController.class);
    
    @GetMapping(path = "hello")
    public String hello() {
        log.info("hello everyone!!");
        return "success";
    }
    
    @GetMapping(path = "oom")
    public void oom() {
        log.info("oom");
        Long i = 1L;
        List<String> list = new LinkedList<>();
        for (; ; ) {
            String s = String.valueOf(i);
            list.add(s);
            i++;
        }
    }
    
}
