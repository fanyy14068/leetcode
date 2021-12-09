package com.fanyy.leetcode.stack;

/**
 * @author fanyuanyuan
 * @data 12/9/21
 */

public class Sword0003 {
    /**
     * 原地交换，空间复杂度O(1)
     */
    static class Solution {
        public int findRepeatNumber(int[] nums) {
            int i = 0;
            while(i < nums.length) {
                if(nums[i] == i) {
                    i++;
                    continue;
                }
                if(nums[nums[i]] == nums[i]) return nums[i];
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            return -1;
        }
    }

}
