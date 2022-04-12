package com.devil.basic.lock;

/**
 * Synchronized锁测试
 *
 * @author Devil
 * @date Created in 2022/1/10 14:18
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        test.test1();
        test.test2();
        SynchronizedTest.test3();
    }

    /**
     * 修饰代码块
     * public void test1();
     * descriptor: ()V
     * flags: ACC_PUBLIC
     * Code:
     * stack=2, locals=3, args_size=1
     * 0: aload_0
     * 1: dup
     * 2: astore_1
     * 3: monitorenter
     * 4: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
     * 7: ldc           #7                  // String test1获得锁 输出
     * 9: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     * 12: aload_1
     * 13: monitorexit
     * 14: goto          22
     * 17: astore_2
     * 18: aload_1
     * 19: monitorexit   // 异常退出 有可能因为第一次退不出 补偿退出
     * 20: aload_2
     * 21: athrow
     * 22: return
     */
    public void test1() {
        synchronized (this) {
            System.out.println("test1获得锁 输出");
        }
    }

    /**
     * 修饰方法
     * public synchronized void test2();
     * descriptor: ()V
     * flags: ACC_PUBLIC, ACC_SYNCHRONIZED
     * Code:
     * stack=2, locals=1, args_size=1
     * 0: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
     * 3: ldc           #9                  // String test2获得锁 输出
     * 5: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     * 8: return
     */
    public synchronized void test2() {
        System.out.println("test2获得锁 输出");
    }

    /**
     * 修饰静态方法
     * public static synchronized void test3();
     * descriptor: ()V
     * flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
     * Code:
     * stack=2, locals=0, args_size=0
     * 0: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
     * 3: ldc           #10                 // String test3获得锁 输出
     * 5: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     * 8: return
     */
    public synchronized static void test3() {
        System.out.println("test3获得锁 输出");
    }

}
