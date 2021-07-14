package com.devil.basic.structure.list;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 链表map的lru
 *
 * @author Devil
 * @date Created in 2021/7/8 10:16
 */
public class LinkedHashMapLruTest<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LinkedHashMapLruTest(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<>(10, 0.75f, true);
        map.put(9, 3);
        map.put(7, 4);
        map.put(5, 9);
        map.put(3, 4);
        //现在遍历的话顺序肯定是9,7,5,3
        //下面访问了一下9,3这个键值对，输出顺序就变喽~
        map.get(9);
        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            System.out.println(it.next().getKey());
        }

        System.out.println("================");

        LinkedHashMapLruTest<Integer, Integer> lru = new LinkedHashMapLruTest<>(3);
        lru.put(9, 3);
        lru.put(7, 4);
        lru.put(5, 9);
        lru.put(3, 4);
        for (Iterator<Map.Entry<Integer, Integer>> it = lru.entrySet().iterator(); it.hasNext(); ) {
            System.out.println(it.next().getKey());
        }
    }

}
