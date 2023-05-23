package com.dsa.java8;

import java.util.List;
import java.util.regex.Pattern;

public class IntegerFinder {
    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static void main(String... s){
        List<String> ls =  List.of("as", "123", "32", "2as");
        List<Integer> ans = ls.stream().filter(IntegerFinder::isNumber).map(Integer::parseInt).toList();
        ans.forEach(System.out::println);

    }

    private static boolean isNumber(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
