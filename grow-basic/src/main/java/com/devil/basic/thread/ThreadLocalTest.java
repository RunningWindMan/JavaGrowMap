package com.devil.basic.thread;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    
    public void test2() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    
        threadLocal.set("threadLocal-value");
        inheritableThreadLocal.set("inheritableThreadLocal-value");
    
        // 验证父子线程传递
        new Thread(() -> {
            System.out.println(threadLocal.get()); // null
            System.out.println(inheritableThreadLocal.get()); //inheritableThreadLocal-value
        }).start();
    
        threadLocal.remove();
        inheritableThreadLocal.remove();
    }
    
    public void test3() {
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        // 验证线程池传递
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            inheritableThreadLocal.set("inheritableThreadLocal-value->" + i);
            executorService.submit(() -> {
                System.out.println(inheritableThreadLocal.get());
            });
        }
        executorService.shutdown();
        inheritableThreadLocal.remove();
    }
    
    public void test4() {
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();
        // 验证线程池传递2
        ExecutorService executorService2 = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));
        for (int i = 0; i < 10; i++) {
            inheritableThreadLocal.set("inheritableThreadLocal-value->" + i);
            transmittableThreadLocal.set("transmittableThreadLocal-value->" + i);
            executorService2.submit(() -> {
                System.out.println(inheritableThreadLocal.get());
                System.out.println(transmittableThreadLocal.get());
            });
        }
        executorService2.shutdown();
        inheritableThreadLocal.remove();
        transmittableThreadLocal.remove();
    }
    
    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
//        test.test1();
//        test.test1();
        
//        test.test2();
        
//        test.test3();
        
        test.test4();
    }
    
}
