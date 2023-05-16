package com.dsa.dynamicprograming;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {
    /**
     * <a href="https://autocode-next.lab.epam.com/courses/1379/syllabus/5685">Autocode -> Number of Dice Rolls With Target Sum</a>
     * <a href="https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/">Leetcode</a>
     */
    public static void main(String... s){
        NumberOfDiceRollsWithTargetSum rollsWithTargetSum = new NumberOfDiceRollsWithTargetSum();
        System.out.println( rollsWithTargetSum.numRollsToTarget(30,30,500));
    }
    public int numRollsToTarget(int n, int k, int target) {
        int [][] dp = new int[n][target];
        Arrays.stream(dp).forEach(c->Arrays.fill(c,-1));
        return rollDice(n,k,target,dp);
    }
    private int rollDice(int n, int k, int target, int[][] dp) {
        int count=0;
        int MOD = (int)(1e9+7);
        if(target<=0 || n==1){
            if(target>0 && target<=k){
                count = 1;
            }
        }else {
            if(dp[n-1][target-1]!=-1){
                count = dp[n-1][target-1];
            }else{
                for (int t = target-1; t >= target-k; t--) {
                    count = (rollDice(n - 1, k, t, dp)%MOD+ count)%MOD;
                }
                dp[n-1][target-1] = count;
            }
        }
        return count;
    }
}