package com.devil.basic.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * id:0
 * id:4
 * id:3
 * id:2
 * id:1
 * 线程组执行结束
 * 线程组任务1结束，其他任务继续
 * 线程组任务3结束，其他任务继续
 * 线程组任务2结束，其他任务继续
 * 线程组任务0结束，其他任务继续
 * 线程组任务4结束，其他任务继续
 * ===================
 * id:11
 * id:12
 * id:13
 * id:14
 * id:15
 * 线程组执行结束
 * 线程组任务15结束，其他任务继续
 * 线程组任务12结束，其他任务继续
 * 线程组任务13结束，其他任务继续
 * 线程组任务14结束，其他任务继续
 * 线程组任务11结束，其他任务继续
 *
 * @author Devil
 * @date Created in 2021/7/20 23:38
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("线程组执行结束");
            }
        });
        for (int i = 0; i < 5; i++) {
            new Thread(new CyclicBarrierThread(i, cyclicBarrier)).start();
        }

        Thread.sleep(2000);
        System.out.println("===================");

        // CyclicBarrier可以重复利用，这个是CountDownLatch做不到的
        for (int i = 11; i < 16; i++) {
            new Thread(new CyclicBarrierThread(i, cyclicBarrier)).start();
        }

    }

    static class CyclicBarrierThread implements Runnable {

        private int id;
        private CyclicBarrier barrier;

        public CyclicBarrierThread(int id, CyclicBarrier barrier) {
            this.id = id;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println("id:" + id);
            try {
                barrier.await();
                System.out.println("线程组任务" + id + "结束，其他任务继续");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
