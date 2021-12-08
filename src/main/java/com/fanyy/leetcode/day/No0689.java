package com.fanyy.leetcode.day;

/**
 * @author fanyuanyuan
 * @data 12/8/21
 * //给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。
 * //
 * // 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [1,2,1,2,6,7,5,1], k = 2
 * //输出：[0,3,5]
 * //解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
 * //也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
 * //输出：[0,2,4]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 2 * 104
 * // 1 <= nums[i] < 216
 * // 1 <= k <= floor(nums.length / 3)
 * //
 * // Related Topics 数组 动态规划
 * // 👍 189 👎 0
 */

public class No0689 {
    static class Solution {
        /**
         * Tips: 问题拆分，首先考虑一个的情况，然后两个，然后三个
         *　滑动窗口解法
         * @param nums
         * @param k
         * @return
         */

        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int[] ret = new int[] {0, k, 2*k};
            int sum1 = 0, sum2 = 0, sum3 = 0;
            int[] idx2 = new int[2]; int maxIdx1 = 0;
            int maxS1 = 0, maxS12 = 0, maxS123 = 0;
            for(int i=2*k;i<nums.length;i++) {
                sum1 += nums[i-2*k];
                sum2 += nums[i-k];
                sum3 += nums[i];
                if (i >= 3*k - 1) {
                    if (sum1 > maxS1) {
                        maxS1 = sum1;
                        maxIdx1 = i - 3*k + 1;
                    }
                    if ((maxS1 + sum2) > maxS12) {
                        maxS12 = sum2 + maxS1;
                        idx2 = new int[]{maxIdx1, i-2*k + 1};
                    }
                    if ((maxS12 + sum3) > maxS123) {
                        maxS123 = maxS12 + sum3;
                        ret = new int[]{idx2[0], idx2[1], i - k + 1};
                    }
                    sum1 -= nums[i-3*k+1];
                    sum2 -= nums[i-2*k+1];
                    sum3 -= nums[i-k+1];
                }
            }
            return ret;

        }

        public int[] maxSumOfTwoSubArrays(int[] nums, int k) {
            int[] ret = new int[] {0, k};
            int sum1 = 0, sum2 = 0;
            int maxS1 = 0, maxS12 = 0;
            for(int i=k;i<=nums.length-k+1;i++) {
                sum1 += nums[i-k];
                sum2 += nums[i];
                if (i > 2*k - 1) {
                    if (sum1 > maxS1) {
                        maxS1 = sum1;
                        ret[0] = i - k;
                    }
                    if ((maxS1 + sum2) > maxS12) {
                        maxS12 = sum2;
                        ret[1] = i;
                    }
                    sum1 -= nums[i-2*k+1];
                    sum2 -= nums[i-k+1];
                }
            }
            return ret;

        }

        /**
         * 动态规划:
         * d(i, j) 表示到第j个元素时，前i个不重叠的子组的最大值
         * d(i,j)=max(d(i, j-1), d(i－１, j-k) + sum(j) - sum(j-k))
         * @param nums
         * @param k
         * @return
         */

        public int[] maxSumOfThreeSubarrays2(int[] nums, int k) {
            // 动态规划，有点麻烦，需要保存之前的位置
            int[][] dp = new int[3][nums.length];
            int[][][] idx = new int[3][nums.length][3];
            for(int i=0;i<3;i++) {
                int s = 0;
                for(int j=0;j<nums.length;j++) {
                    if (j <= k - 1) { // 前面的元素无法构成k个元素
                        s += nums[j];
                        dp[i][j] = s;
                    } else {
                        s += (nums[j] - nums[j-k]);
                        int t0 = i == 0 ? 0 : dp[i-1][j-k];
                        if (s + t0 > dp[i][j-1]) {
                            dp[i][j] = s + t0;
                            if (i == 0) {
                                idx[i][j] = new int[]{j-k+1, 0, 0};
                            } else if (i == 1) {
                                idx[i][j] = new int[]{idx[i-1][j-k][0], j-k+1, 0};
                            } else {
                                idx[i][j] = new int[]{idx[i-1][j-k][0], idx[i-1][j-k][1], j-k+1};
                            }
                        } else {
                            dp[i][j] = dp[i][j-1];
                            idx[i][j] = idx[i][j-1];
                        }
                    }
                }
            }
            return idx[2][nums.length-1];

        }

        public int[] maxSumOfThreeSubarrays3(int[] nums, int k) {
            int n = nums.length, maxsum = 0;
            int[] sum = new int[n+1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
            for (int i = 0; i < n; i++) sum[i+1] = sum[i]+nums[i];
            // DP for starting index of the left max sum interval
            for (int i = k, tot = sum[k]-sum[0]; i < n; i++) {
                if (sum[i+1]-sum[i+1-k] > tot) {
                    posLeft[i] = i+1-k;
                    tot = sum[i+1]-sum[i+1-k];
                }
                else
                    posLeft[i] = posLeft[i-1];
            }
            // DP for starting index of the right max sum interval
            // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
            posRight[n-k] = n-k;
            for (int i = n-k-1, tot = sum[n]-sum[n-k]; i >= 0; i--) {
                if (sum[i+k]-sum[i] >= tot) {
                    posRight[i] = i;
                    tot = sum[i+k]-sum[i];
                }
                else
                    posRight[i] = posRight[i+1];
            }
            // test all possible middle interval
            for (int i = k; i <= n-2*k; i++) {
                int l = posLeft[i-1], r = posRight[i+k];
                int tot = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
                if (tot > maxsum) {
                    maxsum = tot;
                    ans[0] = l; ans[1] = i; ans[2] = r;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,6,7,5,1};
        int[] ret = new Solution().maxSumOfThreeSubarrays3(nums, 2);
        for(int i: ret) {
            System.out.println(i);
        }


    }
}

