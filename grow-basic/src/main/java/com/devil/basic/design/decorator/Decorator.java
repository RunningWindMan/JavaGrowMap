package com.devil.basic.design.decorator;

/**
 * 装饰器抽象类
 *
 * @author Devil
 * @date Created in 2021/7/27 13:47
 */
public abstract class Decorator implements DecorateInterface {

    private DecorateInterface decorateInterface;

    public Decorator(DecorateInterface decorateInterface) {
        this.decorateInterface = decorateInterface;
    }

    @Override
    public void get() {
        decorateInterface.get();
    }

}
