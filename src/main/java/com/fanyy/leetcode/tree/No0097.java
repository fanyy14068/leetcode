package com.fanyy.leetcode.tree;

/**
 * @author fanyuanyuan
 * @data 12/12/21
 */

public class No0097 {
    static class Solution {
        /**
         * Tips: 双指针会有问题，所以采用动态规划
         * 动态规划　f(i, j) = (f(i-1, j) && s3(i+j-1)=s1(i-1)) || (f(i, j-1) && s3(i+j-1)=s2(j-1))
         */
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length();
            int n = s2.length();
            int t = s3.length();
            if (m + n != t) {
                return false;
            }
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;

            for(int i=0;i<=m;i++) {
                for(int j=0;j<=n;j++) {
                    if (i > 0) {
                        dp[i][j] |= dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) ;
                    }
                    if (j > 0) {
                        dp[i][j] |= dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                    }

                }
            }
            return dp[m][n];

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
