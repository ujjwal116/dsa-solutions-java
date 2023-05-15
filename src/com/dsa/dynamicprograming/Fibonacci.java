package com.dsa.dynamicprograming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String... s){
        int n = 50;
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(n));
    }

    private Map<Integer,Long> fibMap = new HashMap<>();
    private Long fib(int n) {
        if (fibMap.containsKey(n)){
            return fibMap.get(n);
        }
        if(n==0){
            fibMap.put(n,0L);
            return 0L;
        }
        if(n==1){
            fibMap.put(n,1L);
            return 1L;
        }
        Long ans = fib(n-1)+fib(n-2);
        fibMap.put(n,ans);
        return ans;
    }
}
