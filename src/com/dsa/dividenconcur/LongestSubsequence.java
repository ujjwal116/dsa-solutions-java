package com.dsa.dividenconcur;
import java.util.*;

// Given an array a[] find the length of longest subsequence
// [5,13,6,7,1,2,14,15,3,4,8,9,12]
//longest subsequence is-> 1,2,3,4,5,6,7,8,9 and ans is ->9
public class LongestSubsequence {
    //solution: make a set of all the elements.
    //iterate through the array and find left number and right number of the current number.

    public static void main(String... s){
        List<Integer> list = Arrays.asList(5,13,6,7,1,2,14,15,3,4,8,9,12);
        Set<Integer> set = new HashSet<>(Arrays.asList(5,13,6,7,1,2,14,15,3,4,8,9,12));
        int max = 0;
        int count = 0;
        int i = 0;
        while(!set.isEmpty()){
            count = 0;
            if(set.contains(list.get(i))){
                set.remove(list.get(i));
                count++;
                count = count+findLeft(set,list.get(0));
                count = count+findRight(set,list.get(0));

            }
            i++;
            max = Math.max(count, max);
        }
        System.out.println("ans is: "+max);

    }

    private static int findLeft(Set<Integer> set, Integer n) {
        int count = 0;
        if(set.contains(n-1)){
            count++;
            set.remove(n-1);
            count = count + findLeft(set,n-1);
        }
        return count;
    }

    private static int findRight(Set<Integer> set, Integer n) {
        int count = 0;
        if(set.contains(n+1)){
            count++;
            set.remove(n+1);
            count = count + findRight(set,n+1);
        }
        return count;
    }
}
