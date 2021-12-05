package com.fanyy.leetcode.search;

/**
 * @author fanyuanyuan
 * @data 12/4/21
 * No.704
 * 二分查找
 */

public class No0704 {
    static class Solution{
        public int search(int[] nums, int target) {
            int n = nums.length;
            int t = 0;
            int left = 0;
            int right = n-1;
            while (right >= left  ) {
                t = (left + right) / 2;
                if (nums[t] > target) {
                    right = t - 1;
                } else if (nums[t] < target) {
                    left = t + 1;
                } else {
                    return t;
                }
            }
            return -1;
        }

        /**
         * No.278. 第一个错误的版本
         * @param n
         * @return
         */
        public int firstBadVersion(int n) {
            int high = n;
            int low = 1;
            int middle;
            while (low < high) {
                middle = (high - low) / 2 + low;  // low + high 可能会超出int上限
                if (isBadVersion(middle)) {
                    high = middle;
                } else {
                    low = middle + 1;
                }
            }
            return high;
        }

        public boolean isBadVersion(int num) {
            return num == 1702766719;
        }

        /**
         * 35. 搜索插入位置
         * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
         请必须使用时间复杂度为 O(log n) 的算法。
         有序一般用二分查找，这里注意target可能比所有的值都大
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
            int high = nums.length-1;
            int low = 0;
            int mid;
            int ans = nums.length;
            while(low < high) {
                mid = (high - low) / 2 + low;
                if (nums[mid] >= target) {
                    ans = mid;
                    high = mid - 1;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                }
            }
            return ans;
        }


    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        int[] b = {10, 15};
//        System.out.println(new Solution().minCostClimbingStairs(a));
        System.out.println(new Solution().searchInsert(a, 2));
    }
}
