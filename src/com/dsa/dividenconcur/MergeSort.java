package com.dsa.dividenconcur;

import java.util.Arrays;

public class MergeSort {
    public static void main(String... s){
        int[] a = {1,6,5,8,3,9,3};
        mergeSort(a,0, a.length-1);
        Arrays.stream(a).forEach(System.out::print);
    }

    private static void mergeSort(int[] a, int l, int h) {
        if(h>l){
            int mid = (l+h)/2;
            mergeSort(a,l,mid);
            mergeSort(a,mid+1,h);
            merge(a,l,h);
        }
    }

    private static void merge(int[] a, int l, int h) {
        int mid = (l+h)/2;
        int [] la = Arrays.copyOfRange(a,l,mid+1);
        int[] ra = Arrays.copyOfRange(a,mid+1,h+1);
        int i = 0;
        int j = 0;
        int k = l;

        while(k<=h){
            if(i==la.length || j==ra.length){
                break;
            }
            if(la[i]<ra[j]){
                a[k] = la[i];
                i++;
            }else {
                a[k] = ra[j];
                j++;
            }
            k++;

        }
        if(i< la.length){
            while(i<la.length){
                a[k] = la[i];
                i++;
                k++;
            }
        }

        if(j< ra.length){
            while(j<ra.length){
                a[k] = ra[j];
                j++;
                k++;
            }
        }

    }
}
