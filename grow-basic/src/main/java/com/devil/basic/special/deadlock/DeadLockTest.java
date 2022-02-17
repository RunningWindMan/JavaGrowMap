package com.devil.basic.special.deadlock;

/**
 * @author Devil
 * @date Created in 2021/7/28 9:38
 */
public class DeadLockTest {

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock(0);
        DeadLock deadLock2 = new DeadLock(1);
        deadLock1.start();
        deadLock2.start();
    }

}

class DeadLock extends Thread {

    private int flag;

    /**
     * 声明为static是为了获取类锁   否则是对象锁
     */
    private static Object x1 = new Object();
    private static Object x2 = new Object();

    public DeadLock(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println(flag);
        try {
            if (flag == 0) {
                synchronized (x1) {
                    System.out.println(flag + "锁住了x1");
                    Thread.sleep(1000);
                    synchronized (x2) {
                        System.out.println(flag + "锁住了x2");
                    }
                    System.out.println(flag + "释放了x1和x2");
                }
            }
            if (flag == 1) {
                synchronized (x2) {
                    System.out.println(flag + "锁住了x2");
                    Thread.sleep(1000);
                    synchronized (x1) {
                        System.out.println(flag + "锁住了x1");
                    }
                    System.out.println(flag + "释放了x1和x2");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}