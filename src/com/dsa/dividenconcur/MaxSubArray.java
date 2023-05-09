package com.dsa.dividenconcur;

public class MaxSubArray {
        /**
         * <a href="https://leetcode.com/problems/maximum-subarray/description/">Autocode -> Maximum Subarray</a>
         * <a href="https://autocode-next.lab.epam.com/courses/1379/syllabus/5686">Leetcode</a>
         */
        public static void main(String... s){
            int[] nums = {-2, -5, 6, -2, -3, 1, 5, -6};
            System.out.println(maxSumSubArray(nums, 0, nums.length-1));
        }
        public int maxSubArray(int[] nums) {
            return maxSumSubArray(new int [] {-2, -5, 6, -2, -3, 1, 5, -6}, 0, nums.length);
        }

    private static int maxSumSubArray(int[] nums, int l, int h) {
            if(l==h){
                return nums[l];
            }
            if((l+1)==h){
                return Math.max(nums[l],nums[h]);
            }
            int mid = (l+h)/2;
            return max(maxSumSubArray(nums,l,mid),maxSumSubArray(nums,mid+1,h),crossSum(nums,l,h));
    }

    static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private static int crossSum(int[] nums, int l, int h) {
            int mid = (l+h)/2;
            int sum = 0;
            int maxSum = Integer.MIN_VALUE;
            for(int i = mid; i>=l;i--){
                sum += nums[i];
                maxSum= Math.max(maxSum, sum);
            }
            sum = maxSum;
            for(int i = mid+1; i<=h;i++){
                sum += nums[i];
                maxSum= Math.max(maxSum, sum);
            }
        return maxSum;
    }
}
