package com.fanyy.leetcode.alg;

/**
 * @author fanyuanyuan
 * @data 12/8/21
 */

public class No0557 {
    static class Solution {
        public String reverseWords(String s) {

            StringBuffer sb = new StringBuffer();
            int i = 0;
            while( i < s.length()) {
                int start = i;
                while (i < s.length() && s.charAt(i) != ' ') {
                    i++;
                }

                for(int j=i-1;j>=start;j--) {
                    sb.append(s.charAt(j));
                }

                while (i < s.length() && s.charAt(i) == ' ') {
                    sb.append(" ");
                    i++;
                }
            }

            return sb.toString();

        }


    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}
