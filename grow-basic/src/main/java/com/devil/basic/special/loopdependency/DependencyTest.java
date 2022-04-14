package com.devil.basic.special.loopdependency;

/**
 * 依赖测试
 *
 * @author Devil
 * @date Created in 2021/7/18 15:59
 */
public class DependencyTest {
    
    public static void main(String[] args) {
        DependenceA a = new DependenceA();
        DependenceB b = new DependenceB(a);
        b.work();
    }
    
}
