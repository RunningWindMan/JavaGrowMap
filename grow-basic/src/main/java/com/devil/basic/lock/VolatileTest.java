package com.devil.basic.lock;

/**
 * @author Devil
 * @date Created in 2022/1/10 16:47
 */
public class VolatileTest {

    private volatile int flag = 1;

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        test.test1();
    }

    public void test1() {
        if (flag == 1) {
            System.out.println("访问Flag 1");
        } else {
            System.out.println("无法访问Flag");
        }
    }

}
