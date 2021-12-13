package com.fanyy.leetcode.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: fanyy
 * Created on 2021/12/13
 */

public class No0560 {
    static class Solution {
        /**
         * 时间复杂度：O(N*N)，空间复杂度O(N)
         */
        public int subarraySum(int[] nums, int k) {
            int ans = 0;
            int n = nums.length;
            int[] sums = new int[n+1];

            for(int i=1;i<=n;i++) {
                sums[i] = sums[i-1] + nums[i-1];
            }

            for(int i=1;i<=n;i++) {
                for(int j=0;j<=n-i;j++) {
                    if (k == sums[j+i] - sums[j] ) {
                        ans += 1;
                    }
                }
            }
            return ans;
        }

        /**
         * 时间复杂度：O(N*N)，空间复杂度O(1)
         */
        public int subarraySum2(int[] nums, int k) {
            int ans = 0;
            int n = nums.length;

            for(int start=0;start<n;start++) {
                int sum = 0;
                for(int end=start;end>=0;end--) {
                    sum += nums[end];
                    if (sum == k) {
                        ans += 1;
                    }
                }
            }
            return ans;
        }

        /**
         * 利用hash表，时间复杂度O(N)
         * pre(i)表示0到i的子数组之和
         * j->i子数组满足要求等价于 pre(i) - pre(j-1) == k
         * 所以到第i个元素时，以pre(i)作为hashmap的key,只需要看pre(i)-k的count即可
         */
        public int subarraySum3(int[] nums, int k) {
            int ans = 0;
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            int pre = 0;
            map.put(0, 1);
            for(int i=0;i<n;i++) {
                pre += nums[i];
                if (map.containsKey(pre - k)) {
                    ans += map.get(pre);
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return ans;
        }


    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int n = new Solution().subarraySum(nums, 3);
        System.out.println(n);

        int k = 2;
    }
}