package com.devil.test;

import com.devil.spring.DevilSpringApplication;
import com.devil.spring.bean.BeanListInject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * spring相关测试
 *
 * @author Devil
 * @date Created in 2022/3/3 14:18
 */
@SpringBootTest(classes = {DevilSpringApplication.class})
public class SpringTest {
    
    @Autowired
    private BeanListInject beanListInject;
    
    @Test
    public void test1() {
        beanListInject.work();
    }
    
}
