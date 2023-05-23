package com.dsa.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreatestElement {
    public static void main(String... s){
        int[]  a = {15, 10, 16, 20, 8, 9, 7, 50};
        printGreatest(a);
    }

    private static void printGreatest(int[] a) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> eToNgeMap = new HashMap<>();
        for (int e: a) {
            if(stack.empty()){
                stack.push(e);
            }else{
                while(!stack.empty()&&stack.peek()<e){
                    eToNgeMap.put(stack.pop(),e);
                }
                stack.push(e);
            }
        }
        while (!stack.empty()){
            eToNgeMap.put(stack.pop(),-1);
        }
        for (int e: a){
            System.out.println(e+"–>"+eToNgeMap.get(e));
        }
    }

}
