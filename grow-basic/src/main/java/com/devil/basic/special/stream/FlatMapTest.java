package com.devil.basic.special.stream;

import java.util.*;

/**
 * @author Devil
 * @date Created in 2021/7/20 16:20
 */
public class FlatMapTest {
    
    public static void main(String[] args) {
        List<List<String>> allList = new LinkedList<>();
        
        List<String> list1 = new LinkedList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        
        List<String> list2 = new LinkedList<>();
        list2.add("11");
        list2.add("22");
        list2.add("33");
        list2.add("44");
        list2.add("55");
        
        allList.add(list1);
        allList.add(list2);
        
        System.out.println("map =============");
        allList.stream().map(x -> x.stream().map(y -> y += "0"))
                .forEach(x -> System.out.println(Arrays.toString(x.toArray())));
        System.out.println("flatmap =============");
        allList.stream().flatMap(x -> x.stream().map(y -> y += "0")).forEach(System.out::println);
    }
    
}
