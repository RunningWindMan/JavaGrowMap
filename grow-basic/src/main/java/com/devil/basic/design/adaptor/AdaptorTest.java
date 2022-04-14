package com.devil.basic.design.adaptor;

/**
 * @author Devil
 * @date Created in 2021/7/27 14:18
 */
public class AdaptorTest {
    
    public static void main(String[] args) {
        AdaptorTarget target = new AdaptorTarget();
        AdaptorInterface adaptorInterface = new AdaptorA(target);
        adaptorInterface.put("222");
        adaptorInterface.get();
    }
    
}
