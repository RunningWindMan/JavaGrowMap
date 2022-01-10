package com.devil.basic.thread;

/**
 * ThreadLocal测试
 *
 * @author Devil
 * @date Created in 2022/1/10 17:15
 */
public class ThreadLocalTest {

    private ThreadLocal<Integer> localStore = new ThreadLocal<>();
    private ThreadLocal<String> localStore2 = new ThreadLocal<>();

    public void test1() {
        Integer i = localStore.get();
        String s = localStore2.get();
        if (i == null) {
            localStore.set(1);
        } else {
            System.out.println(i);
            // 避免内存泄漏
            localStore.remove();
        }
        if (s == null) {
            localStore2.set("2");
        } else {
            System.out.println(s);
            localStore2.remove();
        }
    }

    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        test.test1();
        test.test1();
    }

}
