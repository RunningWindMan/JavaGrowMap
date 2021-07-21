package com.devil.basic.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Devil
 * @date Created in 2021/7/21 15:47
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        ReferenceTest test1 = new ReferenceTest(1, 1);
        ReferenceTest test2 = new ReferenceTest(2, 2);
        ReferenceTest test3 = new ReferenceTest(3, 3);

        AtomicReference<ReferenceTest> reference = new AtomicReference<>();
        reference.set(test1);
        System.out.println("第一次：" + reference.get());
        reference.compareAndSet(test1, test2);
        System.out.println("第二次：" + reference.get());
        reference.compareAndSet(test1, test3);
        System.out.println("第三次：" + reference.get());
    }

    static class ReferenceTest {

        private int id;
        private int name;

        public ReferenceTest(int id, int name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "ReferenceTest{" +
                    "id=" + id +
                    ", name=" + name +
                    '}';
        }
    }

}
