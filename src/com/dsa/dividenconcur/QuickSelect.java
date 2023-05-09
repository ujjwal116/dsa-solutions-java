package com.dsa.dividenconcur;

//Kth largest element
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
public class QuickSelect {
    public static void main(String... s){
        QuickSelect qs = new QuickSelect();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4,3,4,4,5,67,7,7,6,8,8,7,6,4,5,67,7,8,8,9,9};
        System.out.println(nums[qs.quickSelect(nums,0,nums.length-1, nums.length-6)]);
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0){
           throw new IllegalArgumentException();
        }
        return nums[quickSelect(nums,0,nums.length-1, nums.length-k)];

    }

    private int quickSelect(int[] nums, int l, int h, int k) {
        int i = l+1;
        int j = h;
        while(i<=j){
            while(i<nums.length && nums[i]<=nums[l]){
                i++;
            }
            while(nums[j]>=nums[l]&&j>l){
                j--;
            }
            if(i<j) {
                swap(nums, i, j);
            }
        }
        swap(nums,l,j);
        int ans;
        if(k==j){
            ans =  j;
        }else if (k<j) {
            ans = quickSelect(nums, l, j-1, k);
        }else{
            ans = quickSelect(nums,j+1,h, k);
        }

        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums [j];
        nums[j] = temp;
    }


}
