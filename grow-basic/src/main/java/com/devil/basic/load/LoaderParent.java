package com.devil.basic.load;

/**
 * @author Devil
 * @date Created in 2021/7/23 9:52
 */
public class LoaderParent {

    public static final String P_0 = "p0";

    public static String P_1 = "p1";

    static {
        System.out.println("LoaderParent 静态代码块 =====");
    }

    {
        System.out.println("LoaderParent 非静态代码块 =====");
    }

    public LoaderParent() {
        System.out.println("LoaderParent 构造 =====");
    }
}
