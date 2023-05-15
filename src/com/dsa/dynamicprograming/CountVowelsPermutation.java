package com.dsa.dynamicprograming;

import java.util.Arrays;

public class CountVowelsPermutation {
    /**
     * <a href="https://autocode-next.lab.epam.com/courses/1379/syllabus/5682">Autocode -> Count Vowels Permutation</a>
     * <a href="https://leetcode.com/problems/count-vowels-permutation/">Leetcode</a>
     */
    public static void main(String... s) {
        int[][] a = new int[5][5];
        Arrays.stream(a).forEach(a1->Arrays.fill(a1,-1));
       /* CountVowelsPermutation countVowelsPermutation = new CountVowelsPermutation();
        System.out.println(countVowelsPermutation.countVowelPermutation(144));*/
    }

    public int countVowelPermutation(int n) {
        if (n<=0) return 0;
        int MOD = (int)(1e9+7);
        int[][] dp = new int[n][5];
        int a=0,e = 1,i=2,o=3,u=4;
        int c1 = startWith(n,a,dp)%MOD;
        int c2 = startWith(n,e,dp)%MOD;
        int c3 = startWith(n,i,dp)%MOD;
        int c4 = startWith(n,o,dp)%MOD;
        int c5 = startWith(n,u,dp)%MOD;

        return ((((c1 + c2)%MOD + c3)%MOD + c4)%MOD + c5)%MOD;
    }

    private int startWith(int n, int c, int[][] dp) {
        int a=0,e = 1,i=2,o=3,u=4;
        int MOD = (int)(1e9+7);
        int ans = 0;

        if(n==1){
            return 1;
        }else if(dp[n-1][c]!=0){
            return dp[n-1][c];
        }else {
            switch (c) {
                case 0: {
                    ans = startWith(n - 1, e, dp)%MOD;
                    break;
                }
                case 1: {
                    ans = (startWith(n - 1, a, dp) +
                            startWith(n - 1, i, dp)) % MOD;
                    break;
                }
                case 2: {
                    ans = ((startWith(n - 1, a, dp) +
                            startWith(n - 1, e, dp) )%MOD+
                            (startWith(n - 1, o, dp) +
                            startWith(n - 1, u, dp))%MOD) % MOD;
                    break;
                }
                case 3: {
                    ans = (startWith(n - 1, i, dp) +
                            startWith(n - 1, u, dp)) % MOD;
                    break;
                }
                case 4: {
                    ans = startWith(n - 1, a, dp)%MOD;
                    break;
                }
                default:
                    break;

            }
        };
        dp[n-1][c] = ans;
        return ans;
    }


}