package com.devil.basic.proxy.dynamic.jdk;

/**
 * @author Devil
 * @date Created in 2021/7/15 13:37
 */
public class SimpleWorker implements Worker {
    
    @Override
    public String work() {
        System.out.println("工作工作--------");
        return null;
    }
    
}
