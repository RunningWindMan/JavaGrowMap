package com.devil.basic.structure.sort;

/**
 * 插入排序
 *
 * @author Devil
 * @date Created in 2021/7/7 10:55
 */
public class InsertionSort implements Sort {

    public static void main(String[] args) {
        Sort sort = new InsertionSort();
        int[] a = new int[]{1, 6, 2, 4, 5, 8};
        sort.sort(a, a.length);
        sort.print(a);
    }

    @Override
    public void sort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        // 假设第一个元素是有序集合
        for (int i = 1; i < n; i++) {
            // 保存当前值
            int value = a[i];
            // 查询有序集合
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    // 默认之前的都已排序好，不需要再排序
                    break;
                }
            }
            // 最后塞入当前值
            a[j + 1] = value;
        }
    }
}
