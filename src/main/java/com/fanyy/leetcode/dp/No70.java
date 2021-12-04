package com.fanyy.leetcode.dp;

/**
 * @author fanyuanyuan
 * @data 12/4/21
 * No.70, No.746
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

public class No70 {
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

        public int minCostClimbingStairs(int[] cost) {
            if (cost.length <= 2) {
                return 0;
            }
            int a0 = cost[0];
            int a1 = cost[1];
            int sum = 0;
            for(int i=2;i<cost.length;i++) {
                sum = Math.min(a0+cost[i], a1);
                a0 = a1;
                a1 = sum;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] b = {10, 15, 20};
        System.out.println(new Solution().minCostClimbingStairs(a));
//        System.out.println(new Solution().minCostClimbingStairs(b));
    }
}
