package com.devil.spring.controller;

import com.devil.spring.service.ThreadPoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Devil
 * @date Created in 2022/3/14 14:05
 */
@RestController
@RequestMapping(value = "threadpool")
public class ThreadPoolTestController {

    private static final Logger log = LoggerFactory.getLogger(ThreadPoolTestController.class);

    @Autowired
    private ThreadPoolService threadPoolService;

    @GetMapping(value = "test")
    public String test() {
        log.info("iiiiiiiiiiiiiiiiiiiiiiiiiii");
        threadPoolService.asyncTest();
        return "fail";
    }

}
