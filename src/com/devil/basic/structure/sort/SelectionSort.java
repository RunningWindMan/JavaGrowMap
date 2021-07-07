package com.devil.basic.structure.sort;

/**
 * 选择排序
 *
 * @author Devil
 * @date Created in 2021/7/7 13:35
 */
public class SelectionSort implements Sort {

    public static void main(String[] args) {
        Sort sort = new SelectionSort();
        int[] a = new int[]{1, 6, 2, 4, 5, 8};
        sort.sort(a, a.length);
        sort.print(a);
    }

    @Override
    public void sort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; i++) {
            int value = a[i];
            int min = i;
            // 找最小
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            a[i] = a[min];
            a[min] = value;
        }
    }
}
