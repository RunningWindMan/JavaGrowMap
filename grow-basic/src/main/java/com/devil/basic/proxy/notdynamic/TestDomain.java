package com.devil.basic.proxy.notdynamic;

/**
 * @author Devil
 * @date Created in 2021/7/15 11:58
 */
public class TestDomain implements Domain {
    
    @Override
    public String get() {
        System.out.println("test -- == ++");
        return null;
    }
    
}
