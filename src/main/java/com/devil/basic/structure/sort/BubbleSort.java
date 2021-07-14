package com.devil.basic.structure.sort;

/**
 * 冒泡排序
 *
 * @author Devil
 * @date Created in 2021/7/7 10:16
 */
public class BubbleSort implements Sort {

    public static void main(String[] args) {
        Sort sort = new BubbleSort();
        int[] a = new int[]{1, 6, 2, 4, 5, 8};
        sort.sort(a, a.length);
        sort.print(a);
    }

    @Override
    public void sort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                // 交换
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
    }

}
