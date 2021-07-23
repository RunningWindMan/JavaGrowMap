package com.devil.basic.load;

import javax.annotation.PostConstruct;

/**
 * @author Devil
 * @date Created in 2021/7/23 9:31
 */
public class Loader extends LoaderParent {

    /**
     * 静态块只加载一次
     */
    static {
        System.out.println("load 静态块加载 ===");
    }

    /**
     * 非静态块每次new执行一次  优先于构造函数
     */
    {
        System.out.println("load 非静态块加载 ===");
    }

    public static final String FLAG = "flag";

    public static String anotherFlag = "anotherFlag";

    /**
     * 次注解依赖于框架  支持此注解的框架才会执行  而且优先于构造函数
     */
    @PostConstruct
    void init() {
        System.out.println("load init =====");
    }

    public Loader() {
        System.out.println("load 构造 ===");
    }

    private String name;

    public Loader(String name) {
        this.name = name;
    }

    private void load(String name) {
        name = name + "====";
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Loader{" +
                "name='" + name + '\'' +
                '}';
    }
}
