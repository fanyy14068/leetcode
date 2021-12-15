package com.fanyy.leetcode.other;

/**
 * @author: fanyy
 * Created on 2021/12/15
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    必须 原地 修改，只允许使用额外常数空间。

 */

public class No0031 {
    static class Solution{
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 1;
            while(i > 0) {
                if (nums[i-1] < nums[i]) {
                    break;
                }
                i--;
            }

            if (i != 0) {
                int j = n - 1;
                while(j >= i) {
                    if (nums[j] > nums[i-1]) {
                        break;
                    }
                    j--;
                }

                int tmp = nums[j];
                nums[j] = nums[i-1];
                nums[i-1] = tmp;

            }


            int left = i;
            int right = n - 1;
            while(left < right) {
                int tmp1 = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp1;
                left ++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}};

    }

}