package com.dsa;

class IntSum {
    public static void main(String[] args) {
        System.out.println(sumOfIntegers(null));
    }

    public static int sumOfIntegers(int[] input) {
        int i = 0;
        if(null==input || input.length==0){
            return 0;
        }
        long sum =  sum(i, input);

        if(sum>2147483647L || sum< -2147483648L ){
            return 0;
        }else{
            return (int)sum;
        }
    }

    private static long sum(int i, int[] input){
        if(i==input.length-1){
            return input[input.length-1];
        }
        return input[i]+sum(i+1,input);
    }
}