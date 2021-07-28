package com.devil.basic.special.oom;

import java.util.LinkedList;
import java.util.List;

/**
 * oom测试
 *
 * @author Devil
 * @date Created in 2021/7/28 9:03
 */
public class OomTest {

    public static void main(String[] args) {
        OomTest test = new OomTest();
//        test.oomTest();
        test.stackOverFlowTest(1);
    }

    /**
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     */
    public void oomTest() {
        Long i = 1L;
        // 需要持有对象，这样可达性判断才不会标记为需要清除
        List<OomBean> list = new LinkedList<>();
        for(;;) {
            OomBean oomBean = new OomBean(i, String.valueOf(i));
            System.out.println(oomBean.toString());
            list.add(oomBean);
            i++;
        }
    }

    /**
     * Exception in thread "main" java.lang.StackOverflowError
     */
    public int stackOverFlowTest(int n) {
        return stackOverFlowTest(n);
    }


}
