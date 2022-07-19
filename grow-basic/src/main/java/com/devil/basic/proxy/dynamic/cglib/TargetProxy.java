package com.devil.basic.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * target代理类
 *
 * @author Devil
 * @date Created in 2022/7/19 10:50
 */
public class TargetProxy implements MethodInterceptor {
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理前 ==============");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib代理后 ==============");
        return o1;
    }
    
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetClass.class);
        enhancer.setCallback(new TargetProxy());
        TargetClass targetClass = (TargetClass) enhancer.create();
        targetClass.run();
    }
}
