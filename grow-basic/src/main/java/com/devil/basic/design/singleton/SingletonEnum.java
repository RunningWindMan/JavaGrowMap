package com.devil.basic.design.singleton;

/**
 * 枚举单例
 *
 * @author Devil
 * @date Created in 2022/3/14 11:12
 */
public enum SingletonEnum {

    /**
     * 实例
     */
    INSTANCE;

    public void doSomething() {
        System.out.println("doSomething");
    }

}
