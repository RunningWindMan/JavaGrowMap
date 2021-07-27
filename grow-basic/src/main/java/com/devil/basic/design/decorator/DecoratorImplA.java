package com.devil.basic.design.decorator;

/**
 * @author Devil
 * @date Created in 2021/7/27 14:05
 */
public class DecoratorImplA extends Decorator {

    public DecoratorImplA(DecorateInterface decorateInterface) {
        super(decorateInterface);
    }

    public void extraGet() {
        System.out.println("decoratorA get=====");
    }

}
