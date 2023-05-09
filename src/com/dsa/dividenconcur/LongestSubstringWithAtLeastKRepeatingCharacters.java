package com.dsa.dividenconcur;

public class LongestSubstringWithAtLeastKRepeatingCharacters  {
    public static void main(String... a){
        String s = "ababacb";
        LongestSubstringWithAtLeastKRepeatingCharacters obj = new LongestSubstringWithAtLeastKRepeatingCharacters();
       System.out.println( obj.longestSubstring(s,3)) ;
    }
    public int longestSubstring(String s, int k) {
        if(s==null || s.length()==0){
            return 0;
        }
        return maxSubstringLength(s.toCharArray(),0,s.length()-1,k);
    }

    private int maxSubstringLength(char[] charArray, int l, int h, int k) {
        if(l==h){
            return k==1?1:0;
        }
        int[] freq = getFreqArray(charArray,l,h);
        int max = 0;
        int i;
        for (i = l; i<=h;i++) {
            int fr = getFreq(freq,charArray,i);
            if(fr<k){
                break;
            }
            max= Math.max(i - l+1, max);
        }
        if(i>h){
            return h-l+1;
        }
        return Math.max(i==0?0:maxSubstringLength(charArray,l, i-1,  k),maxSubstringLength(charArray,i+1, h,  k));

    }

    private int getFreq(int[] freq, char[] charArray, int i) {
        return freq[charArray[i]-'a'];
    }

    private int[] getFreqArray(char[] charArray, int l, int h) {
        int[] freq = new int[26];
        for (int i  = l;i<=h;i++) {
            freq[charArray[i]-'a']++;
        }
        return freq;
    }
}
