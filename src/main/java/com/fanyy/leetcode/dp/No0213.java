package com.fanyy.leetcode.dp;

/**
 * @author fanyuanyuan
 * @data 12/6/21
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * Tips:　我自己的解法: 分偷盗第１家和不偷盗第１家两种情况处理；官方回答是分两段，比较[0, n-2]和[1, n-1]这两个范围的最大值，用198的思路进行求解
 */

public class No0213 {
    static class Solution{
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }

            int s1 = rob1(nums, true); // 偷盗第一家, start = nums[0], pre = nums[0]
            int s2 = rob1(nums, false); // 不偷盗第一家， start = 0, pre = nums[1]
            return Math.max(s1, s2);


        }

        public int rob1(int[] nums, boolean flag) {
            int ret = 0;
            int pre = flag ? nums[0] : 0;
            int cur = flag ? nums[0] : nums[1];
            for(int i=2;i<nums.length;i++) {
                ret = Math.max(pre + nums[i], cur);
                pre = cur;
                cur = ret;
            }
            if (flag &&  ret > pre) {
                return pre; // 进了第一家，最后一家不能进去
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(new Solution().rob(nums));
    }

}
