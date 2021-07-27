package com.devil.basic.sort;

/**
 * 快速排序
 *
 * @author Devil
 * @date Created in 2021/7/16 20:30
 */
public class QuickSort implements Sort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 2, 4, 5, 8};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a, a.length);
        quickSort.print(a);
    }

    @Override
    public void sort(int[] a, int n) {
        if (a == null || n == 0) {
            return;
        }
        quickSort(a, 0, n - 1);
    }

    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = partition(a, low, high);
            quickSort(a, low, mid - 1);
            quickSort(a, mid + 1, high);
        }
    }

    private int partition(int[] a, int low, int high) {
        int value = a[low];
        while (low < high) {
            while (value <= a[high] && low < high) {
                high--;
            }
            if (low < high) {
                a[low] = a[high];
                low++;
            }
            while (value >= a[low] && low < high) {
                low++;
            }
            if (low < high) {
                a[high] = a[low];
                high--;
            }
        }
        a[low] = value;
        return low;
    }

}
