package com.devil.basic.load;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 类加载测试
 *
 * @author Devil
 * @date Created in 2021/7/23 9:28
 */
public class LoadTest {
    
    public static void main(String[] args) {
        //        // 常量访问不会触发类加载
        //        System.out.println(Loader.FLAG);
        //        System.out.println("======================");
        //        // 静态变量和new访问会触发类加载
        //        System.out.println(Loader.anotherFlag);
        //        System.out.println("======================");
        //        Loader loader1 = new Loader();
        //        System.out.println(loader1.toString());
        //        Loader loader2 = new Loader();
        //        System.out.println(loader2.toString());
        //        System.out.println("======================");
        //        // 访问父类常量
        //        System.out.println(Loader.P_0);
        //        System.out.println("======================");
        // 访问父类静态变量不会触发子类构造
        System.out.println(Loader.P_1);
        System.out.println("======================");
        
        // class forname
        //        String className = "com.devil.basic.load.Loader";
        //        try {
        //            Class loadClass = Class.forName(className);
        //            System.out.println("Parent loader: " + loadClass.getClassLoader().getParent().toString());
        //            System.out.println(loadClass.getClassLoader().toString());
        //            // Class[]
        //            Class[] c = {String.class};
        //            Constructor declaredConstructor = loadClass.getDeclaredConstructor(c);
        //            Object o = declaredConstructor.newInstance("234");
        //            System.out.println(o.toString());
        //            // private method
        //            Method method = loadClass.getDeclaredMethod("load", String.class);
        //            method.setAccessible(true);
        //            Object[] args1 = {"ttyyuu"};
        //            method.invoke(o, args1);
        //        } catch (ClassNotFoundException e) {
        //            e.printStackTrace();
        //        } catch (NoSuchMethodException e) {
        //            e.printStackTrace();
        //        } catch (InvocationTargetException e) {
        //            e.printStackTrace();
        //        } catch (InstantiationException e) {
        //            e.printStackTrace();
        //        } catch (IllegalAccessException e) {
        //            e.printStackTrace();
        //        }
        
    }
    
}
