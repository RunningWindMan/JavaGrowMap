package com.devil.basic.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Devil
 * @date Created in 2021/7/21 15:32
 */
public class AtomicIntegerTest {
    
    private String name;
    
    public AtomicIntegerTest(String name) {
        this.name = name;
    }
    
    public AtomicIntegerTest() {
        this("AtomicIntegerTest-" + serialNumber());
    }
    
    private final static AtomicInteger nextSerialNumber = new AtomicInteger(0);
    
    private static int serialNumber() {
        return nextSerialNumber.getAndIncrement();
    }
    
    public static void main(String[] args) {
        AtomicIntegerTest test1 = new AtomicIntegerTest();
        AtomicIntegerTest test2 = new AtomicIntegerTest();
        System.out.println(test1.name);
        System.out.println(test2.name);
    }
    
}
