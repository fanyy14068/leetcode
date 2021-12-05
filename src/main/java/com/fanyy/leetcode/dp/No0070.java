package com.fanyy.leetcode.dp;

/**
 * @author fanyuanyuan
 * @data 12/4/21
 * No.70, No.746
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

public class No0070 {
    static class Solution{
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            int r = 3;
            int a0 = 1;
            int a1 = 2;
            for(int i=3;i<n;i++) {
                a0 = a1;
                a1 = r;
                r = a0 + a1;
            }
            return r;
        }
//
//        public int minCostClimbingStairs(int[] cost) {
//            if (cost.length <= 1) {
//                return 0;
//            }
//            if (cost.length == 2) {
//                return Math.min(cost[0], cost[1]);
//            }
//            int a0 = 0;
//            int a1 = Math.min(cost[0], cost[1]);
//            int sum = 0;
//            for(int i=2;i<cost.length;i++) {
//                sum = Math.min(a1+cost[i], a0 + cost[i-1]);
//                a0 = a1;
//                a1 = sum;
//            }
//            return sum;
//        }

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
    }

    public static void main(String[] args) {
        int[] a = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] b = {10, 15};
//        System.out.println(new Solution().minCostClimbingStairs(a));
        System.out.println(new Solution().minCostClimbingStairs(b));
    }
}
