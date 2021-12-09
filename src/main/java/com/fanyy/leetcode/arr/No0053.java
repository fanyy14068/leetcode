package com.fanyy.leetcode.arr;

/**
 * @author fanyuanyuan
 * @data 12/9/21
 * //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * //
 * // 子数组 是数组中的一个连续部分。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * //输出：6
 * //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [1]
 * //输出：1
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [5,4,-1,7,8]
 * //输出：23
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 105
 * // -104 <= nums[i] <= 104
 * //
 * //
 * //
 * //
 * // 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * // Related Topics 数组 分治 动态规划
 * // 👍 4080 👎 0
 */

public class No0053 {
    static class Solution {
        /**
         * dp: f(n) 表示以n结尾的连续子数组的最大和
         * f(n) = max(f(n-1) + nums[n-1], nums[n-1])
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            if (nums.length <= 1) {
                return nums[0];
            }

            int max = nums[0];
            int cur = nums[0];
            for(int i=1;i<nums.length;i++) {
                if (cur < 0) {
                    cur = nums[i];
                } else {
                    cur += nums[i];
                }
                max = Math.max(max, cur);
            }

            return max;

        }

        /**
         * 复杂度太高O(N*N)
         * @param nums
         * @return
         */
        public int maxSubArray1(int[] nums) {


            if (nums.length <= 1) {
                return nums[0];
            }

            int[] sums = new int[nums.length + 1];
            for(int i=0;i<nums.length;i++) {
                sums[i+1] = sums[i] + nums[i];
            }

            int max = -10000;
            for(int i=0;i<nums.length;i++) {
                for(int j=i+1;j<=nums.length;j++) {
                    if (sums[j] - sums[i] > max) {
                        max = sums[j] - sums[i];
                    }
                }
            }

            return max;

        }

        /**
         * 分治法
         */
        public class Status {
            public int lSum, rSum, mSum, iSum;

            public Status(int lSum, int rSum, int mSum, int iSum) {
                this.lSum = lSum;
                this.rSum = rSum;
                this.mSum = mSum;
                this.iSum = iSum;
            }
        }

        public int maxSubArray2(int[] nums) {
            return getInfo(nums, 0, nums.length - 1).mSum;
        }

        public Status getInfo(int[] a, int l, int r) {
            if (l == r) {
                return new Status(a[l], a[l], a[l], a[l]);
            }
            int m = (l + r) >> 1;
            Status lSub = getInfo(a, l, m);
            Status rSub = getInfo(a, m + 1, r);
            return pushUp(lSub, rSub);
        }

        public Status pushUp(Status l, Status r) {
            int iSum = l.iSum + r.iSum;
            int lSum = Math.max(l.lSum, l.iSum + r.lSum);
            int rSum = Math.max(r.rSum, r.iSum + l.rSum);
            int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
            return new Status(lSum, rSum, mSum, iSum);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}
