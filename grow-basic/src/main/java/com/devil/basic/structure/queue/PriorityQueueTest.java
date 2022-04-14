package com.devil.basic.structure.queue;

import java.util.PriorityQueue;

/**
 * 优先级队列  寻找一数组中前K个最大的数
 *
 * @author Devil
 * @date Created in 2021/7/12 15:59
 */
public class PriorityQueueTest {
    
    public static void topK(int[] a, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int i = 0; i < a.length; i++) {
            if (i < k) {
                priorityQueue.offer(a[i]);
            }
            if (a[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(a[i]);
            }
        }
        int len = priorityQueue.size();
        for (int i = 0; i < len; i++) {
            System.out.println(priorityQueue.poll() + " ");
        }
    }
    
    public static void main(String[] args) {
        int[] a = new int[] {3, 4, 6, 2, 1, 6, 7, 8, 9};
        topK(a, 4);
    }
    
}
