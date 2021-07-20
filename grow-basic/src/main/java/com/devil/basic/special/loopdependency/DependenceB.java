package com.devil.basic.special.loopdependency;

/**
 * 依赖B
 *
 * @author Devil
 * @date Created in 2021/7/18 15:58
 */
public class DependenceB {

    private DependenceA a;

    public DependenceB(DependenceA a) {
        this.a = a;
    }

    public void work() {
        a.work();
        System.out.println("B work");
    }

}
