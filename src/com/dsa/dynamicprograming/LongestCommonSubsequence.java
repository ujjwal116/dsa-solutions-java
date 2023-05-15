package com.dsa.dynamicprograming;

import java.util.Arrays;

//https://leetcode.com/problems/longest-common-subsequence/submissions/950659634/
class LongestCommonSubsequence {
    public static void main(){
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        longestCommonSubsequence.longestCommonSubsequence("AGGTAB","GXTXAYB");
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        Arrays.stream(dp).forEach(a1->Arrays.fill(a1,-1));
        return lcm(text1.toCharArray(),text2.toCharArray(),0,0,dp);
    }

    public int lcm(char[] s1, char[] s2, int i1, int i2,int[][] dp){
        int ans;
        if(i1==s1.length || i2==s2.length){
           ans=0;
        }else{
            if(dp[i1][i2]!=-1){
                ans = dp[i1][i2];
            }else{
                if(s1[i1]==s2[i2]){
                    ans = 1+ lcm(s1,s2,i1+1,i2+1,dp);
                }else{
                    ans = Math.max(lcm(s1,s2,i1+1,i2,dp),lcm(s1,s2,i1,i2+1,dp));
                }
                dp[i1][i2] = ans;
            }
            
           
        }
        
         return ans;
    }
}