package com.fanyy.leetcode.day;

/**
 * @author: fanyy
 * Created on 2021/12/22
 * 重复叠加字符串匹配
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * 示例 1：

    输入：a = "abcd", b = "cdabcdab"
    输出：3
    解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 */



public class No0686 {
    static class Solution {
        public int repeatedStringMatch(String a, String b) {
            int t = kmp(a, b);
            if (t < 0) {
                return -1;
            }
            if (a.length() - t >= b.length()) {
                return 1;
            }
            return (b.length() + t - a.length() - 1) / a.length() + 2;


        }

        public int kmp(String str, String patten) {
            int[] next = new int[patten.length()];
            int j = 0;
            for(int i=2;i<patten.length();i++) {
                while(j!=0 &&  patten.charAt(j) != patten.charAt(i-1)) {
                    j = next[j];
                }
                if (patten.charAt(i-1) == patten.charAt(j)) {
                    j++;
                }
                next[i] =j;
            }

            int k = 0;
            int n = str.length();
            int m = patten.length();
            for(int i=0;i-k<n;i++) {
                while(k > 0 && str.charAt(i%n) != patten.charAt(k)) {
                    k = next[k];
                }
                if (str.charAt(i%n) == patten.charAt(k)) {
                    k++;
                }
                if (k == m) {
                    return i-m+1;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kmp("abcd", "cdabcdab"));
//        System.out.println(new Solution().kmp( "cbabcdab", "abcd"));
    }
}