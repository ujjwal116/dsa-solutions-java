package com.dsa.backtracking;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConstructSmallestNumberFromDIString {
    public String constructSmallestNumberFromDIString(String input) {
        if(null==input || input.length()==0){
            return "";
        }
        int[] num = new int[input.length()+1];
        buildNumber(input.toCharArray(),num);
        return Arrays.stream(num).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    private void buildNumber(char[] input, int[] num) {
        int countD = 0;
        int max = 0;
        for(int j=input.length-1 ;j>=0;j--){
            if(input[j]=='D'){
                countD++;
                num[j]=countD;
            }else{
                countD=0;
            }
        }
        for(int i=0;i<num.length;i++) {
            if(i==num.length-1 ){
                if(input[i - 1] == 'D') {
                    num[i] = num[i - 1] - 1;
                }else{
                    num[i] = max + 1;
                    max++;
                }
            }else if(i==0 && input[i] == 'D'){
                num[i] = num[i] + 1 ;
                max = num[i];
            }else {
                if (i == 0 || (input[i - 1] == 'I' && input[i] == 'I')) {
                    num[i] = max + 1;
                    max++;
                } else if (input[i - 1] == 'I' && input[i] == 'D') {
                    num[i] = num[i] + 1 + max;
                    max = num[i];
                } else {
                    num[i] = num[i - 1] - 1;
                }
            }
        }
    }
}
