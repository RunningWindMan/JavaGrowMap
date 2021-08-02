package com.devil.basic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Devil
 * @date Created in 2021/8/2 16:15
 */
public class ConditionTest {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

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
            try {
                lock.lock();
                System.out.println("我在等一个新信号" + Thread.currentThread().getName());
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("拿到一个信号" + Thread.currentThread().getName());
                lock.unlock();
            }
        }
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("我拿到锁" + Thread.currentThread().getName());
                condition.signalAll();
                System.out.println("我发出了一个信号：" + Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }
        }
    }


}
