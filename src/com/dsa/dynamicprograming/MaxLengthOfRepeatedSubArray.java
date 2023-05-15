package com.dsa.dynamicprograming;

import java.util.Arrays;

class MaxLengthOfRepeatedSubArray {
    /**
     * <a href="https://autocode-next.lab.epam.com/courses/1379/syllabus/5684">Autocode -> Maximum Length Of Repeated Subarray</a>
     * <a href="https://leetcode.com/problems/maximum-length-of-repeated-subarray/">Leatcode</a>
     */
    public static void main(String... s){
        MaxLengthOfRepeatedSubArray maxLengthOfRepeatedSubArray = new MaxLengthOfRepeatedSubArray();
        System.out.println( maxLengthOfRepeatedSubArray.findLength(new int[]{0,0,0,0,0}, new int[]{0,0,0,0}));
    }
    public int findLength(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null  || nums1.length==0 || nums2.length==0){
            return 0;
        }
        int[][] dp = new int [nums1.length][nums2.length];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return lsa(nums1,nums2,0,0,dp);
    }

    private int lsa(int[] a1, int[] a2, int i1, int i2, int[][] dp) {
        int ans;
        if(a1.length==i1 || a2.length==i2) {
            ans = 0;
        }else if(dp[i1][i2]!=-1){
            ans = dp[i1][i2];
        }else if(a1[i1]==a2[i2] ){
            ans = 0;
            int i = i1;
            int j= i2;
            while (i<a1.length && j<a2.length && a1[i]==a2[j] ){
                ans++;
                i++;
                j++;
            }
            ans = Math.max(ans,lsa(a1,a2,i,j, dp));
        }else{
            ans = Math.max(lsa(a1,a2,i1+1,i2, dp),lsa(a1,a2,i1,i2+1, dp));
            dp[i1][i2] = ans;
        }
        return ans;
    }
}