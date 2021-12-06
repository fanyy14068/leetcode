package com.fanyy.leetcode.alg;

import java.util.Arrays;

/**
 * @author fanyuanyuan
 * @data 12/6/21
 */

public class No0977 {
    static class Solution {
        public int[] sortedSquares(int[] nums) {
//            int[] ret = new int[nums.length];
//            for(int i=0;i<nums.length;i++) {
//                ret[i] = nums[i] * nums[i];
//            }
//            Arrays.sort(ret);
//            return ret;

            // 双指针
            int left = 0;
            int right = nums.length - 1;
            int[] ret = new int[nums.length];
            int k = right;
            while(left <= right) {
                if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                    ret[k] = nums[left] * nums[left];
                    left += 1;
                } else {
                    ret[k] = nums[right] * nums[right];
                    right -= 1;
                }
                k -= 1;
            }

            return ret;

        }
    }

    public static void main(String[] args) {

        int[] nums = {-4,-1,0,3,10};
        int[] z = new Solution().sortedSquares(nums);
        for(int i=0;i<z.length;i++) {
            System.out.println(z[i]);
        }
    }
}
