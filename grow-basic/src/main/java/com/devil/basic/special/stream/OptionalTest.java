package com.devil.basic.special.stream;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author Devil
 * @date Created in 2021/7/19 14:57
 */
public class OptionalTest {
    
    private HashMap<Integer, Test> map = new HashMap<>();
    
    public static void main(String[] args) {
        OptionalTest test = new OptionalTest();
        test.addTest(1);
        test.addTest(2);
        test.getTest(1);
        test.getTest(3);
    }
    
    public void addTest(int code) {
        if (!map.containsKey(code)) {
            map.put(code, new Test(code));
        }
    }
    
    public Integer getTest(int code) {
        // Optional的orElse和orElseGet不同，orElse总会执行
        //        return Optional.ofNullable(map.get(code)).orElse(new Test(code)).code;
        return Optional.ofNullable(map.get(code)).orElseGet(() -> new Test(code)).code;
    }
    
    class Test {
        
        private int code;
        
        public Test(int code) {
            System.out.println("创建Test: code" + code);
            this.code = code;
        }
        
        /**
         * @return the code
         */
        public int getCode() {
            return code;
        }
    }
    
}
