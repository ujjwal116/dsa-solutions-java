package com.dsa.binarysearch;

public class CountOnes {
    public  static void main(String... s){
        int[] a = new int[] {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2};
        int[] ans = {a.length/2, a.length/2};
        countOnes(0, a.length-1, a,ans);
       System.out.println(ans[0]+"   "+ans[1]);
    }

    public static void countOnes(int l, int h, int[] a,int[] ans){
        if(isLeft(a,ans[0]) && isRight(a,ans[1])){
            return;
        }
        if (!isLeft(a,ans[0])){
            int midl = (l+ans[0])/2;
            if(a[midl]==0){
                l=midl;
            }else {
                ans[0]=midl;
            }
        }
        if (!isRight(a,ans[1])){
                int midh = (h+ans[1])/2;
                if(a[midh]==2){
                    h=midh;
                }else {
                    ans[1]=midh;
                }
        }
        countOnes(l,h,a,ans);
    }

    private static boolean isRight(int[] a, int i) {
        if(i==a.length-1){
            return a[i]==1;
        }
        return a[i]==1 && a[i+1]==2;
    }

    public static boolean isLeft(int[] a, int i){
        if(i==0){
            return a[i]==1;
        }
        return a[i]==1 && a[i-1]==0;
    }

}