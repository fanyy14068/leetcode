package com.fanyy.leetcode.alg;

/**
 * @author fanyuanyuan
 * @data 12/13/21
 * Tips: 快慢指针，比较当前值和慢指针的倒数第二个即可
 */

public class No0080 {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length <= 2) {
                return nums.length;
            }
            int slow = 2;
            int fast = 2;

            while(fast < nums.length) {
                if (nums[fast] != nums[slow-2]) {
                    nums[slow] = nums[fast];
                    ++slow;
                }
                ++fast;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int n = new Solution().removeDuplicates(nums);
        System.out.println(n);
        for(int i=0;i<n;i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
