package com.devil.basic.structure.list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * lru
 *
 * @author Devil
 * @date Created in 2021/7/8 10:36
 */
public class LruTest {

    public static class ListNode {
        ListNode prev;
        ListNode next;
        int key, value;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ListNode head = new ListNode(0, 0);
    ListNode tail = new ListNode(0, 0);
    Map<Integer, ListNode> map = new HashMap<>();

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // write code here
        head.next = tail;
        tail.prev = head;
        LinkedList<Integer> list = new LinkedList<>();
        for (int[] operator : operators) {
            int operation = operator[0];
            if (operation == 1) {
                int key = operator[1];
                int value = operator[2];
                put(key, value, k);
            } else if (operation == 2) {
                int key = operator[1];
                list.add(get(key));
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void put(int key, int value, int k) {
        if (map.containsKey(key)) {
            remove(key);
        }
        if (map.size() == k) {
            remove(head.next.key);
        }
        add(key, value);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        remove(key);
        add(key, node.value);
        return node.value;
    }

    public void add(int key, int value) {
        ListNode node = new ListNode(key, value);
        map.put(key, node);
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(int key) {
        ListNode node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(key);
    }

}
