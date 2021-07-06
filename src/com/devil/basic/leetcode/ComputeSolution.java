package com.devil.basic.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 计算2的1000次方
 *
 * @author Devil
 * @date Created in 2021/6/25 9:21
 */
public class ComputeSolution {

    public static final Integer COUNT = 1000;

    public static void arrayCompute() {
        // 数组存储每一位的数字
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            if (num.isEmpty()) {
                // 设置初始值
                num.add(2);
            } else {
                // 进位数，初始为0
                int inc = 0;
                for (int j = 0; j < num.size(); j++) {
                    // 对应位数上乘以2
                    int multi = num.get(j) * 2;
                    // 获取下次进位数
                    int forward = (multi + inc) / 10;
                    // 进位数和结果相加，获取个位数
                    int data = (multi + inc) % 10;
                    // 替换原来对应位置上的数字
                    num.set(j, data);
                    inc = forward;
                }
                // 如果进位数大于零，那么进位数需要加入链表，进行下次计算
                if (inc > 0) {
                    num.add(inc);
                }
            }
        }

        /**
         * 打印结果
         */
        for (int k = num.size() - 1; k >= 0; k--) {
            System.out.print(num.get(k));
            if (k == 0) {
                System.out.println("\n");
            }
        }
    }

    public static void bigIntegerCompute() {
        BigInteger b = new BigInteger("1");
        for (long i = 1; i <= COUNT; i++) {
            b = b.multiply(new BigInteger("2"));
        }
        System.out.println(b);
    }

    /**
     * 用数组计算2^1000
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("数组实现：");
        arrayCompute();
        System.out.println("==========================================");
        System.out.println("biginteger实现");
        bigIntegerCompute();
    }

}
