package com.devil.basic.design.adaptor;

/**
 * @author Devil
 * @date Created in 2021/7/27 14:17
 */
public class AdaptorA implements AdaptorInterface {
    
    private AdaptorTarget target;
    
    public AdaptorA(AdaptorTarget target) {
        this.target = target;
    }
    
    @Override
    public void put(String s) {
        this.target.put(s);
    }
    
    @Override
    public void get() {
        System.out.println("get =======");
    }
}
