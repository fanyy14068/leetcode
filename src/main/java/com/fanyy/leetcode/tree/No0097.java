package com.fanyy.leetcode.tree;

/**
 * @author fanyuanyuan
 * @data 12/12/21
 */

public class No0097 {
    static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int p1 = 0;
            int p2 = 0;
            boolean ret = true;
            int c = 0;
            if (s3 == "") {
                return s1 == "" && s2 == "";
            }
            while(p1 < s1.length() || p2 < s2.length()) {
                if (c >= s3.length()) {
                    return false;
                }
                if (p1 < s1.length() && s3.charAt(c) == s1.charAt(p1)) {
                    p1 += 1;
                    c += 1;
                } else if (p2 < s2.length() && s3.charAt(c) == s2.charAt(p2)) {
                    p2 += 1;
                    c += 1;
                } else {
                    return false;
                }


            }
            return ret;

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
