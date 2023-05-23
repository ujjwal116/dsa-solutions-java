package com.dsa.java8;

import java.util.*;
import java.util.stream.Collectors;

public class MaxNumberOfVowelsInWord {
    public static void main(String... a) {
        String s = "The quick brown fox jumps right over the little lazy dog.";
        Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(MaxNumberOfVowelsInWord::getVowelCount, Collectors.toList()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getKey))
                .ifPresent(e -> System.out.println(e.getValue()));
    }

    private static Long getVowelCount(String w) {
        return w.chars().filter(c -> 'a' == (char) c || c == 'e' || c == 'i' || c == 'o' || c == 'u').count();
    }
}
