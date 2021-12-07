package com.fanyy.leetcode.alg;

import javax.security.auth.Subject;

/**
 * @author fanyuanyuan
 * @data 12/7/21
 */

public class No0283 {
    static class Solution {

        // 交换之后，left才会右移一个
        public void moveZeroes(int[] nums) {
            int n = nums.length, left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    ++left;
                }
                ++right;
            }

        }

        public void swap(int[] nums, int left, int right) {
            if (left == right) {
                return;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new Solution().moveZeroes(nums);
        for(int i: nums) {
            System.out.println(i);
        }
        System.out.println(-1 % 7);
    }
}
