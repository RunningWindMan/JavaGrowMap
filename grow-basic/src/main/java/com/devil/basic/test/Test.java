package com.devil.basic.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试类
 *
 * @author Devil
 * @date Created in 2021/7/29 15:52
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        String timeString = "2021-06-23 16:17:21";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(timeString);
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis);
        long studyTime = date.getTime();
        System.out.println(studyTime);
        // int越界  2（31）- 1   有符号位： 01111111 11111111 11111111 11111111  超过后截断 可能变成 11111111 ~~ 导致变成负数
        int intTerminal = (int) (currentTimeMillis - studyTime);
        System.out.println(intTerminal);
        long longTerminal = currentTimeMillis - studyTime;
        System.out.println(longTerminal);
        System.out.println(Integer.MAX_VALUE);
    }

}
