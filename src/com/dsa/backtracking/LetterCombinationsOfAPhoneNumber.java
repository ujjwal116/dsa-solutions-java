package com.dsa.backtracking;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfAPhoneNumber {
    static Map<Integer,String[]> digitToLetterMap = Map.of(2,new String[]{"a","b","c"},
            3,new String[]{"d","e","f"},
            4,new String[]{"g","h","i"},
            5,new String[]{"j","k","l"},
            6,new String[]{"m","n","o"},
            7,new String[]{"p","q","r","s"},
            8,new String[]{"t","u","v"},
            9,new String[]{"w","x","y","z"});
    public static void main(String... s){
        LetterCombinationsOfAPhoneNumber c = new LetterCombinationsOfAPhoneNumber();
        System.out.println(c.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if(null == digits||digits.length()==0){
            return List.of();
        }
        return getCombinations(digits.toCharArray(),0);
    }

    private List<String> getCombinations(char[] digits, int i) {
        if(i==digits.length-1){
            return Arrays.stream(digitToLetterMap.get(digits[i]-'0')).collect(Collectors.toList());
        }
        List<String> postList =  getCombinations(digits,i+1);
        List<String> ans = new ArrayList<>();
        Arrays
                .stream(digitToLetterMap.get(digits[i]-'0'))
                .forEach(preString->
                    ans.addAll(postList
                            .stream()
                            .map(postString-> new StringBuilder(preString)
                                    .append(postString)
                                    .toString())
                            .collect(Collectors.toList())));
        return ans;

    }
}