package com.devil.basic.structure.heap;

/**
 * 堆测试
 * 完全二叉树：
 * <blockquote>
 * 7
 * <br>
 * 8       9
 * <br>
 * 12  13  11
 * </blockquote>
 * <blockquote>
 * ||
 * <br>
 * V
 * </blockquote>
 * <blockquote>
 * 数组： 7  8  9  12  13  11
 * <br>
 * 小标： 0  1  2  3   4   5
 * </blockquote>
 *
 * @author Devil
 * @date Created in 2021/7/21 16:47
 */
public class HeapTest {

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int parent(int i) {
        // i为根结点
        if (i == 0) {
            return -1;
        }
        // (i - 1) >>> 1
        return (i - 1) / 2;
    }

    /**
     * 构造大顶堆（找最小）
     */
    public void highestHeap(int[] a, int i, int heapLength) {
        int l = left(i);
        int r = right(i);
        int largest = -1;
        /**
         * 下面两个if条件句用来找到三个元素中的最大元素的位置largest；
         * l < heapLength说明l在数组内，i非叶子结点；
         */
        if (l < heapLength && a[i] < a[l]) {
            largest = l;
        } else {
            largest = i;
        }
        // r < heapLength说明r在数组内
        if (r < heapLength && a[largest] < a[r]) {
            largest = r;
        }
        // 如果i处元素不是最大的，就把i处的元素与最大处元素交换，交换会使元素下降
        if (i != largest) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            // 交换元素后，以a[i]为根的树可能不在满足大根堆性质，于是递归调用该方法
            highestHeap(a, largest, heapLength);
        }
    }

    /**
     * 构造小顶堆（找最大）
     */
    public void lowestHeap(int[] a, int i, int heapLength) {
        int l = left(i);
        int r = right(i);
        int smallest = -1;
        /*
          下面两个if条件句用来找到三个元素中的最小元素的位置smallest；
          s < heapLength说明l在数组内，i非叶子结点；
         */
        if (l < heapLength && a[i] > a[l]) {
            smallest = l;
        } else {
            smallest = i;
        }
        // r < heapLength说明r在数组内
        if (r < heapLength && a[smallest] > a[r]) {
            smallest = r;
        }
        // 如果i处元素不是最小的，就把i处的元素与最小处元素交换，交换会使元素下降
        if (i != smallest) {
            int temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            // 交换元素后，以a[i]为根的树可能不在满足小根堆性质，于是递归调用该方法
            lowestHeap(a, smallest, heapLength);
        }
    }

    public void buildHighestHeap(int[] a, int heapLength) {
        // 从后往前看，（heapLength - 1 - 1）/2 处之后的所有元素都是叶子结点，所以找到最后一个元素的父节点，向前构成大顶堆
        int lengthParent = parent(heapLength - 1);
        for (int i = lengthParent; i >= 0; i--) {
            highestHeap(a, i, heapLength);
        }
    }

    public void buildLowestHeap(int[] a, int heapLength) {
        int lengthParent = parent(heapLength - 1);
        for (int i = lengthParent; i >= 0; i--) {
            lowestHeap(a, i, heapLength);
        }
    }

}
