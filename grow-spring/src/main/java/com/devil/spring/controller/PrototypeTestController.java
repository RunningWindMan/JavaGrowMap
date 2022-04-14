package com.devil.spring.controller;

import com.devil.spring.bean.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Devil
 * @date Created in 2021/7/20 14:13
 */
@RestController
@RequestMapping(path = "prototypeTest")
public class PrototypeTestController {
    
    @Autowired
    private PrototypeBean prototypeBean;
    
    @GetMapping(path = "prototypeByAutowired")
    public Integer prototypeTest() {
        return prototypeBean.getCode();
    }
    
}
