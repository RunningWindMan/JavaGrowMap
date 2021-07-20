package com.devil.basic.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 正在等待所有玩家准备好
 * thread id: 1 已准备好
 * thread id: 0 已准备好
 * thread id: 3 已准备好
 * thread id: 2 已准备好
 * 开始游戏
 *
 * @author Devil
 * @date Created in 2021/7/20 23:15
 */
public class CountDownLaunchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < latch.getCount(); i++) {
            new Thread(new CountDownLaunchThread(i, latch), "player" + i).start();
        }
        System.out.println("正在等待所有玩家准备好");
        latch.await();
        System.out.println("开始游戏");
    }

    static class CountDownLaunchThread implements Runnable {

        private int id;
        private CountDownLatch latch;

        public CountDownLaunchThread(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("thread id: " + id + " 已准备好");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        }
    }

}
