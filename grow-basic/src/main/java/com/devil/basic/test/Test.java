package com.devil.basic.test;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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

//        Map<Integer, Integer> map = new HashMap<>();
//        map.values().forEach(System.out::println);

//        String s = "";
//        String[] split = s.split(",");
//        System.out.println(split.length);

//        String s = "";
//        List<String> strings = Arrays.stream(s.split(",")).collect(Collectors.toList());
//        strings.add("1");
//        System.out.println(strings);

//        String urlEncode = null;
//        try {
//            urlEncode = URLEncoder.encode("https://scu-1258763073.cos.ap-beijing.myqcloud.com/temp/trends/1442842704576389121/storage/emulated/0/UCDownloads/pictures/aidu.com_image_search_src%3Dhttp%253A%252F%252Fpic2.zhimg.com%252F50%252Fv2-fd3ae186ffc01efba6bcb75b5e36765a_hd.jpg%26refer%3Dhttp%253A%252F%252Fpic2.zhimg.jpg", "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(urlEncode);

//        System.out.println(Integer.MAX_VALUE);

//        String s = null, s1 = null;
//        try {
//            s = URLDecoder.decode("ttp%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F24%2F20160724235805_jumHM.thumb.400_0.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.jpg", "UTF-8");
//            s1 = URLDecoder.decode("http%25253A%25252F%25252Fwiki.rsdx.com%25252Fpages%25252Fviewpage.action%25253FpageId%25253D12550169", "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(s);
//        System.out.println(s1);

//        String s = "http%253A%252F%252Fwiki.rsdx.com%252Fpages%252Fviewpage.action%253FpageId%253D12550169";
//        try {
//            System.out.println(URLEncoder.encode(s, "UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

//        try {
//            boolean result = false;
//            if (!result) {
//                throw new Exception("结果不正常");
//            }
//        } catch (Exception e) {
//            System.out.println("=====异常");
//        } finally {
//            System.out.println(">>>>>>>>>>>>>finally");
//        }

//        List<String> list = new ArrayList<>();
//        String join = String.join(",", list);
//        System.out.println(join);

//        Map<String, Double> map = new LinkedHashMap<>();
//        for (int i = 0; i < 2000; i++) {
//            map.put(String.valueOf(i), (double) i);
//        }
//        System.out.println(map.size());

//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 2000; i++) {
//            list.add(String.valueOf(i));
//        }
//        Map<String, String> map = list.stream().collect(Collectors.toMap(k -> k, v -> v));
//        System.out.println(map.containsKey(new String("1")));
//        System.out.println(map.size());

//        String binaryString = "1010001100100110000100001000010000100001000001000010000100000100001000010000100010010100000";
//        System.out.println();

//        Double d = -200D;
//        System.out.println(0 - d);

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        Integer result = list.stream().reduce((a1, a2) -> a1 - a2 > 0 ? a1 : a2).orElseGet(() -> new Integer("2222"));
//        System.out.println(result);


        List list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        List pageList = startPage(list, 3, 3);
        System.out.println(new Gson().toJson(pageList));
    }

    public static List startPage(List list, Integer pageNum, Integer pageSize) {
        if (list == null) {
            return null;
        }
        if (list.size() == 0) {
            return null;
        }

        Integer count = list.size(); // 记录总数
        Integer pageCount = 0; // 页数
        if (count % pageSize == 0) {
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }

        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引

        if (pageNum != pageCount) {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = fromIndex + pageSize;
        } else {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = count;
        }

        List pageList = list.subList(fromIndex, toIndex);

        return pageList;
    }

}
