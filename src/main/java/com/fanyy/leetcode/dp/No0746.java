package com.fanyy.leetcode.dp;

import java.util.Map;

/**
 * @author fanyuanyuan
 * @data 12/4/21
 *  No.746
 *  数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
    每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
    请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 */

public class No0746 {
    static class Solution{
        /**
         * No.746
         * 这种题不能想太多，推导出动态规划的转移方程之后，直接算即可
         * @param cost
         * @return
         */
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int prev = 0, curr = 0;
            for (int i = 2; i <= n; i++) {
                int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
                prev = curr;
                curr = next;
            }
            return curr;
        }

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

        public int maxSubArray(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int cur = nums[0];
            int max = cur;
            int m = 0;
            boolean flag = cur >= 0;
            for(int i=1;i<nums.length;i++) {
                if (nums[i] >= 0 ) {
                    if (flag) {
                        cur += nums[i];
                    } else {

                        if ((cur + m + nums[i]) < cur || (cur +m+nums[i]) < nums[i]) {
                            if (max < cur) {
                                max = cur;
                            }
                            cur = nums[i];
                        }  else {
                            cur += (m + nums[i]);
                        }
                        flag = true;
                        m = 0;
                    }
                } else {
                    flag = false;
                    m += nums[i];
                }
            }
            return Math.max(max, cur);

        }
    }

    public static void main(String[] args) {
        int[] a = {5,4,-1,7,8};
        int[] b = {10, 15};
//        System.out.println(new Solution().minCostClimbingStairs(a));
        System.out.println(new Solution().maxSubArray(a));
    }


}
