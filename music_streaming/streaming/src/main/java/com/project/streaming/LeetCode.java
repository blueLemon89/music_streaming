package com.project.streaming;

import java.util.Arrays;

public class LeetCode {
    public boolean increasingTriplet(int[] nums) {
        int fi = Integer.MAX_VALUE, se = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= fi) fi = nums[i];
            else if(nums[i] <= se) se = nums[i];
            else return true;
        }
        return false;
    }

    public int compress(char[] chars) {
        int cnt = 1;
        int n = chars.length ;
        if(n == 1) return 1;
        StringBuilder temp = new StringBuilder();
        for(int i = 0 ; i < n - 1 ; i++) {
            if(chars[i] == chars[i+1]) {
                cnt++;
            }
            else {
                temp.append(chars[i]).append(cnt);
                cnt = 1;
            }
        }
        temp.append(chars[n-1]).append(cnt);
        return temp.toString().length();
    }

    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        while(j<nums.length){
            nums[j++]=0;
        }
        for(int i : nums) {
            System.out.println(i);
        }
    }

    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) return true;
        int j = 0;
        for(int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        if(j == s.length()) return true;
        return false;
    }


    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();
        String s = "";
        String t = "ahbgdc";
        System.out.println(leetCode.isSubsequence(s,t));


    }
}
