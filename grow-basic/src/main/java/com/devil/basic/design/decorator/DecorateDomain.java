package com.devil.basic.design.decorator;

/**
 * @author Devil
 * @date Created in 2021/7/27 13:46
 */
public class DecorateDomain implements DecorateInterface {

    @Override
    public void get() {
        System.out.println("simple get======");
    }

}
