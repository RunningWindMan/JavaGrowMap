package com.devil.basic.design.singleton;

/**
 * 单例测试
 * 饿汉模式（没有懒加载）
 * 懒汉模式
 * 嵌套静态类（存在序列化和反射攻击问题）  序列化攻击增加readResolve可以防止破坏   单例攻击注意构造方法
 *
 * @author Devil
 * @date Created in 2021/7/13 11:37
 */
public class SingletonTest {

    /**
     * 堵死 new SingletonTest()
     */
    private SingletonTest() {
    }

    /**
     * 饿汉模式
     */
    private static SingletonTest instanceA = new SingletonTest();
    public static SingletonTest getInstanceA() {
        return instanceA;
    }

    /**
     * 懒汉模式
     */
    private static volatile SingletonTest instanceB;
    public static SingletonTest getInstanceB() {
        if (instanceB == null) {
            synchronized (SingletonTest.class) {
                if (instanceB == null) {
                    instanceB = new SingletonTest();
                }
            }
        }
        return instanceB;
    }

    /**
     * 嵌套静态类模式
     */
    private static class SingletonHolder {
        private static SingletonTest instanceC = new SingletonTest();
    }
    public static SingletonTest getInstanceC() {
        return SingletonHolder.instanceC;
    }

}
