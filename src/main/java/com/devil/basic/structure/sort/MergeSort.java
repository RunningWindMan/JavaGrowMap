package com.devil.basic.structure.sort;

/**
 * @author Devil
 * @date Created in 2021/7/16 21:06
 */
public class MergeSort implements Sort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 2, 4, 5, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a, a.length);
        mergeSort.print(a);
    }

    @Override
    public void sort(int[] a, int n) {
        if (a == null || n == 0) {
            return;
        }
        int[] temp = new int[n];
        mergeSort(a, 0, n - 1, temp);
    }

    private void mergeSort(int[] a, int low, int high, int[] temp) {
        if (low >= high) {
            return;
        }
        int mid = (high + low) / 2;
        mergeSort(a, low, mid, temp);
        mergeSort(a, mid + 1, high, temp);
        merge(a, low, mid, high, temp);
    }

    private void merge(int[] a, int low, int mid, int high, int[] temp) {
        int k = 0;
        int i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }

        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= high) {
            temp[k++] = a[j++];
        }

        k = 0;
        while (low <= high) {
            a[low++] = temp[k++];
        }
    }

}
