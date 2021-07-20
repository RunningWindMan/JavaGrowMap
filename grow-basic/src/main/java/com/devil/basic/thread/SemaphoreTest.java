package com.devil.basic.thread;

import java.util.concurrent.Semaphore;

/**
 * @author Devil
 * @date Created in 2021/7/20 23:54
 */
public class SemaphoreTest {

    private int cacheSize = 0;

    public Semaphore mutex;
    /**
     * 保证了容器空的时候（empty的信号量<=0), 消费者等待
     */
    public Semaphore empty;
    /**
     * 保证了容器满的时候（full的信号量 <= 0），生产者等待
     */
    public Semaphore full;

    public SemaphoreTest(int size) {
        // 二进制信号量，表示互斥锁
        mutex = new Semaphore(1);
        empty = new Semaphore(size);
        full = new Semaphore(0);
    }

    public int getCacheSize() throws InterruptedException {
        return cacheSize;
    }

    public void produce() throws InterruptedException {
        empty.acquire();    // 消耗一个空位
        mutex.acquire();
        cacheSize++;
        System.out.println("生产了一个产品， 当前产品数为" + cacheSize);
        mutex.release();
        full.release();     // 增加了一个产品
    }

    public void consume() throws InterruptedException {
        full.acquire();     // 消耗了一个产品
        mutex.acquire();
        cacheSize--;
        System.out.println("消费了一个产品， 当前产品数为" + cacheSize);
        mutex.release();
        empty.release();    // 增加了一个空位
    }

    static class Consumer implements Runnable {
        private SemaphoreTest cache;

        public Consumer(SemaphoreTest cache) {
            this.cache = cache;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    cache.consume();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class Producer implements Runnable {
        private SemaphoreTest cache;

        public Producer(SemaphoreTest cache){
            this.cache = cache;
        }

        @Override
        public void run() {
            while(true){
                try {
                    cache.produce();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SemaphoreTest cache = new SemaphoreTest(10);

        Producer p = new Producer(cache);
        Consumer c = new Consumer(cache);

        int producerCount = 4, consumerCount = 4;
        for (int i = 0; i < producerCount; i++){
            new Thread(p).start();
        }
        for (int i = 0; i < consumerCount; i++){
            new Thread(c).start();
        }
    }

}
