package com.devil.basic.design.decorator;

/**
 * @author Devil
 * @date Created in 2021/7/27 14:07
 */
public class DecorateTest {

    public static void main(String[] args) {
        DecorateInterface decorateInterface = new DecorateDomain();
        DecoratorImplA a = new DecoratorImplA(decorateInterface);
        a.get();
        a.extraGet();
    }

}
