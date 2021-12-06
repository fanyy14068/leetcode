package com.fanyy.leetcode.dp;

/**
 * @author fanyuanyuan
 * @data 12/6/21
 * No.198 动态规划　a[n] = max(a[n-1], a[n-2] + [cn]
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

 */

public class No0198 {
    static class Solution {
        public int rob(int[] nums) {

            if (nums.length == 1) {
                return nums[0];
            } else if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int pre = nums[0];
            int cur = Math.max(nums[0], nums[1]);
            int next = 0;
            for(int i=2;i<nums.length;i++) {
                next = Math.max(nums[i]+pre, cur);
                pre = cur;
                cur = next;
            }
            return next;

        }
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(new Solution().rob(nums));
    }
}
