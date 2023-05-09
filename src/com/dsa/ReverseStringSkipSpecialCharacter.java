package com.dsa;
//Reverse a given string "s" where special characters stays at their place.

//example: s = "absd%e"- revese=> = "ebsd%a"

public class ReverseStringSkipSpecialCharacter {
    public static void main(String... a){
        String s = "absd%e";
        System.out.println("String s: "+s);
        char[] sChar = s.toCharArray();
        int i= 0;
        int j = s.length()-1;
        while(j>i){
            if (!isSpecialCharacter(sChar[i]) && !isSpecialCharacter(sChar[j])){
                swap(sChar,i,j);
                i++;
                j--;
            }
            if(isSpecialCharacter(sChar[i])){
                i++;
            }
            if(isSpecialCharacter(sChar[j])){
                j--;
            }
        }

        System.out.println(String.valueOf(sChar));
    }

    private static void swap(char[] sChar, int i, int j) {
        char temp = sChar[i];
        sChar[i] = sChar[j];
        sChar[j] = temp;
    }

    private static boolean isSpecialCharacter(char sChar) {
        return !Character.isDigit(sChar)
                && !Character.isLetter(sChar)
                && !Character.isWhitespace(sChar);
    }
}
