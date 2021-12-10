package com.fanyy.leetcode.dp;

/**
 * @author: fanyy
 * Created on 2021/12/10
 *  给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个下标。
 */

public class No0055 {

    /**
     * 维持当前最远可以到的地方
     */
    public boolean canJump(int[] nums) {

        int cur = 0;

        for(int i=0;i<nums.length;i++) {
            if (cur >= i)  {
                cur = Math.max(cur, i + nums[i]);
                if ( cur >= (nums.length - 1)) {
                    return true;
                }
            }
        }
        return false;

    }


    /**
     * 笨办法：遍历两次
     */
    static class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n];
            dp[0] = true;
            for(int i=1;i<n;i++) {
                for(int j=0;j<i;j++) {
                    if (dp[j] && nums[j] >= i-j) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n-1];
        }
    }
}