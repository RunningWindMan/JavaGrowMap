package com.devil.basic.design;

/**
 * 单例测试
 *
 * @author Devil
 * @date Created in 2021/7/13 11:37
 */
public class SingletonTest {

    private static volatile SingletonTest instance;

    public static SingletonTest getInstance() {
        if (instance == null) {
            synchronized (SingletonTest.class) {
                if (instance == null) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

}
