package com.devil.basic.structure.sort;

/**
 * 排序接口
 *
 * @author Devil
 * @date Created in 2021/7/7 10:17
 */
public interface Sort {

    /**
     * 排序方法
     *
     * @param a 整数数组
     * @param n 数组大小
     */
    void sort(int[] a, int n);

    /**
     * 打印
     *
     * @param a 整数数组
     */
    default void print(int[] a) {
        for (int j : a) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

}
