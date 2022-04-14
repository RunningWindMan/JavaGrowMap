package com.devil.basic.special.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用reduce对流中元素累积计算，最后得到一个值
 *
 * @author Devil
 * @date Created in 2021/7/27 17:14
 */
public class ReduceTest {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Integer result = list.stream().reduce((d1, d2) -> {
            System.out.println(d1);
            System.out.println(d2);
            System.out.println("=============");
            if (d1 > d2) {
                return d1;
            } else {
                return d2;
            }
        }).orElseGet(() -> 0);
        System.out.println(result);
    }
    
}
