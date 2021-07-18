package com.devil.basic.special.loopdependency;

/**
 * 依赖A
 *
 * @author Devil
 * @date Created in 2021/7/18 15:57
 */
public class DependenceA {

    private DependenceB b;

    public DependenceA() {
    }

    public DependenceA(DependenceB b) {
        this.b = b;
    }

    public void work() {
        b.work();
        System.out.println("A work");
    }

}
