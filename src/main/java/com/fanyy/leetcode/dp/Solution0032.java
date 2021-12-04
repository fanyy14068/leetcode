package com.fanyy.leetcode.dp;

/**
 * @author fanyuanyuan
 * @data 12/3/21
 */

/*
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class Solution0032 {
    static class Solution {
        public int longestValidParentheses(String s) {
            //
            if (s.length() == 0) {
                return 0;
            }
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            String maxS = "";
            for (int i=0;i<s.length();i++) {
                if (s.charAt(i) == ')' && (s1.length() == 0)) { // 前面不构成合法括号
                    if (s2.length() > maxS.length()) {
                        maxS = s2.toString();
                    }
                    s2 = new StringBuilder(); // 开始新的子串;

                } else if (s.charAt(i) == '(') {
                    s1.append("(");
                } else if (s1.length() > 0 && s1.charAt(s1.length() - 1) == '(') {
                    s2.append("()");
                    s1 = new StringBuilder(s.substring(0, s1.length() - 1));
                }
            }

            return Math.max(maxS.length(), s2.length());
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses("()(()"));
    }


}


