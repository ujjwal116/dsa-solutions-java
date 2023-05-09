package com.dsa;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class CodilityTask2 {
    public static void main(String... args) {
        System.out.println(solution("15:15:00", "15:15:12"));
    }

    public static int solution(String s, String t) {
        int count = 0;
        LocalTime ls = LocalTime.parse(s);
        LocalTime lt = LocalTime.parse(t);

        if (ls.isAfter(lt)) {
            LocalTime temp = ls;
            ls = lt;
            lt = temp;
        }
        if(countChar(ls.format(DateTimeFormatter.ofPattern("HH:mm:ss")))==2){
            count++;
        }
        if(countChar(lt.format(DateTimeFormatter.ofPattern("HH:mm:ss")))==2){
            count++;
        }
        while (ls.isBefore(lt)) {
            ls = ls.plusSeconds(1);
            if(countChar(ls.format(DateTimeFormatter.ofPattern("HH:mm:ss")))==2){
                count++;
            }
        }

        return count;
    }

    private static int countChar(String s) {
        return s.chars().filter(c -> c != ':').mapToObj(c -> (char) c).collect(Collectors.toSet()).size();
    }
}
