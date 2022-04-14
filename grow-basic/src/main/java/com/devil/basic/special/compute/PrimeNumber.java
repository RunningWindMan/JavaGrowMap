package com.devil.basic.special.compute;

import java.util.BitSet;

/**
 * 计算100内素数 （素数即质数，指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数）
 *
 * @author Devil
 * @date Created in 2022/3/2 10:25
 */
public class PrimeNumber {
    
    public static void main(String[] args) {
        int n = 100;
        BitSet b = new BitSet(n);
        int i;
        // 默认0和1都是素数
        for (i = 2; i <= n; i++) {
            b.set(i);
        }
        
        i = 2;
        while (i * i <= n) {
            if (b.get(i)) {
                int k = 2 * i;
                while (k <= n) {
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }
        
        i = 0;
        while (i <= n) {
            if (b.get(i)) {
                System.out.println(i);
            }
            i++;
        }
    }
    
}
