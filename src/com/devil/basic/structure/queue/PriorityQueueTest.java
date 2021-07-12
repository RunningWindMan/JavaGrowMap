package com.devil.basic.structure.queue;

import java.util.PriorityQueue;

/**
 * 优先级队列  寻找一数组中前K个最大的数
 *
 * @author devil
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
        for (int i = 0; i < priorityQueue.size(); i++) {
            System.out.println(priorityQueue.poll() + " ");
        }
    }

}
