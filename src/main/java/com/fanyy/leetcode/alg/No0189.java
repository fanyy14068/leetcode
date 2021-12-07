package com.fanyy.leetcode.alg;

/**
 * @author fanyuanyuan
 * @data 12/7/21
 * //给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * //
 * //
 * //
 * // 示例 1:
 * //
 * //
 * //输入: nums = [1,2,3,4,5,6,7], k = 3
 * //输出: [5,6,7,1,2,3,4]
 * //解释:
 * //向右轮转 1 步: [7,1,2,3,4,5,6]
 * //向右轮转 2 步: [6,7,1,2,3,4,5]
 * //向右轮转 3 步: [5,6,7,1,2,3,4]
 * //
 * //
 * // 示例 2:
 * //
 * //
 * //输入：nums = [-1,-100,3,99], k = 2
 * //输出：[3,99,-1,-100]
 * //解释:
 * //向右轮转 1 步: [99,-1,-100,3]
 * //向右轮转 2 步: [3,99,-1,-100]
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 105
 * // -231 <= nums[i] <= 231 - 1
 * // 0 <= k <= 105
 * //
 * //
 * //
 * //
 * // 进阶：
 * //
 * //
 * // 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * // 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * //
 * //
 * //
 * //
 * //
 * //
 * //
 * // Related Topics 数组 数学 双指针
 * // 👍 1227 👎 0
 */

public class No0189 {
    static class Solution {
        /**
         * 使用额外的数组空间
         * @param nums
         * @param k
         */
        public void rotate1(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            int[] nums2 = new int[n];
            for(int i=0;i<n;i++) {
                nums2[i] = nums[(n-k+i)%n];
            }
            for(int i=0;i<n;i++) {
                nums[i] = nums2[i];
            }
        }

        public void rotate2(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            int count = gcd(n, k); // 遍历的次数为n和k的最大公约数
            for(int start=0;start<count;start++) {
                int current = start;
                int tmp = nums[start]; // tmp保存需要被替换的值, n[k]换成n[0], 下一个把n[2k%n]换成n[k]
                do {
                    current = (current + k) % n;
                    int tmp1 = tmp;
                    tmp = nums[current];
                    nums[current] = tmp1;

                } while(current != start);
            }
        }


        public int gcd(int x, int y) {
            return y > 0 ? gcd(y, x % y) : x;
        }

        /**
         * 翻转：这种方法最是巧妙
         * @param nums
         * @param k
         */
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k %n;
            reverse(nums, 0, n-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, n-1);

        }

        public void reverse(int[] nums, int start, int end) {
            int left = start;
            int right = end;
            while(left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left ++;
                right --;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {-1};
        new Solution().rotate(nums, 2);
        for(int n: nums) {
            System.out.print(n + " ");
        }
    }
}
