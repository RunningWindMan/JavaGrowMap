package com.devil.spring.controller;

import com.devil.spring.bean.PrototypeBean;
import com.devil.spring.util.ApplicationContextUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Devil
 * @date Created in 2021/7/20 14:13
 */
@RestController
@RequestMapping(path = "devilTest2")
public class Test2Controller {

    @GetMapping(path = "prototype")
    public Integer prototypeTest() {
        PrototypeBean prototypeBean = ApplicationContextUtil.getBean(PrototypeBean.class);
        return prototypeBean.getCode();
    }

}
