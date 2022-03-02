package com.devil.basic.sort;

import com.devil.basic.structure.heap.HeapTest;

/**
 * @author Devil
 * @date Created in 2021/7/23 14:25
 */
public class HeapSort implements Sort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 2, 4, 5, 8};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(a, a.length);
        heapSort.print(a);
    }

    @Override
    public void sort(int[] a, int n) {
        // 构建大顶堆，之后交换堆顶和堆尾元素，断开堆尾元素
        HeapTest heap = new HeapTest();
        heap.buildHighestHeap(a, n);

        // 调整堆结构+交换堆顶元素与末尾元素 i>0目的是断开交换前的堆尾元素
        for (int i = n - 1; i > 0; i--) {
            // 将堆顶元素与末尾元素进行交换
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            // 重新对堆进行调整
            heap.highestHeap(a, 0, i);
        }
    }
}
