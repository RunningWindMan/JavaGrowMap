package com.devil.basic.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 测试类
 *
 * @author Devil
 * @date Created in 2021/7/29 15:52
 */
public class Test {

    public static void main(String[] args) throws ParseException {
//        String timeString = "2021-06-23 16:17:21";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = sdf.parse(timeString);
//        long currentTimeMillis = System.currentTimeMillis();
//        System.out.println(currentTimeMillis);
//        long studyTime = date.getTime();
//        System.out.println(studyTime);
//        // int越界  2（31）- 1   有符号位： 01111111 11111111 11111111 11111111  超过后截断 可能变成 11111111 ~~ 导致变成负数
//        int intTerminal = (int) (currentTimeMillis - studyTime);
//        System.out.println(intTerminal);
//        long longTerminal = currentTimeMillis - studyTime;
//        System.out.println(longTerminal);
//        System.out.println(Integer.MAX_VALUE);

//        List<String> list = new LinkedList<>();
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list = list.subList(0, 1);
//        list.forEach(System.out::println);

//        Double d = 43.28888D;
//        Integer i = d.intValue();
//        System.out.println(i);

//        System.out.println(Long.MAX_VALUE);

        Map<Integer, Integer> map = new HashMap<>();
        map.values().forEach(System.out::println);


    }

}
