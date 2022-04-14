package com.devil.basic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition实现的生产消费
 *
 * @author Devil
 * @date Created in 2021/8/2 16:15
 */
public class ConditionTest {
    
    private final Lock lock = new ReentrantLock();
    
    // 消费信号
    private final Condition conCondition = lock.newCondition();
    
    // 生产信号
    private final Condition proCondition = lock.newCondition();
    
    public static void main(String[] args) {
        ConditionTest test = new ConditionTest();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();
        new Thread(consumer).start();
        new Thread(producer).start();
    }
    
    class Consumer implements Runnable {
        
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    System.out.println("------------我在等一个新信号" + Thread.currentThread().getName());
                    proCondition.signal();
                    conCondition.await();
                    System.out.println("------------拿到一个信号" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    
    class Producer implements Runnable {
        
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    System.out.println("我拿到锁" + Thread.currentThread().getName());
                    System.out.println("我发出了一个信号：" + Thread.currentThread().getName());
                    conCondition.signal();
                    proCondition.await();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("信号处理完了：" + Thread.currentThread().getName());
                    lock.unlock();
                }
            }
        }
    }
    
    
}
