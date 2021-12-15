package com.fanyy.leetcode.other;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fanyy
 * Created on 2021/12/15
 */

public class No0018 {
    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList();
            for(int i=0;i<=nums.length-4;i++) {
                if (i>=1 && nums[i] == nums[i-1]) {
                    continue;
                }
                List<List<Integer>> ret = threeSum(nums, target-nums[i], i+1);
                for(List<Integer> list: ret) {
                    list.add(nums[i]);
                    ans.add(list);
                }
            }
            return ans;


        }

         public List<List<Integer>> threeSum(int[] nums, int target, int start) {
            List<List<Integer>> ret = new ArrayList();
            for(int i=start;i<=nums.length-3;i++) {
                int left = i + 1;
                int right = nums.length - 1;
                if (i > start && nums[i] == nums[i-1]) {
                    continue;
                }
                while(left < right) {
                    int sum = nums[i] + nums[left] + nums[right] - target;
                    if (sum < 0) {
                        while(left <= nums.length-2 && nums[left+1] == nums[left]) {
                            left += 1;
                        }
                        left += 1;
                    } else if (sum > 0) {
                        while(right > i+1 && nums[right-1] == nums[right]) {
                            right -= 1;
                        }
                        right -= 1;
                    } else {
                        List<Integer> arr = new ArrayList();
                        arr.add(nums[i]);
                        arr.add(nums[left]);
                        arr.add(nums[right]);
                        ret.add(arr);
                        while(left<nums.length-2 && nums[left+1] == nums[left]) {
                            left += 1;
                        }
                        while(right>i+1 && nums[right-1] == nums[right]) {
                            right -= 1;
                        }

                        left += 1;
                        right -= 1;

                    }
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        Arrays.sort(nums);
//        List<List<Integer>> ret = new Solution().fourSum(nums, 8);
        List<List<Integer>> ret = new Solution().threeSum(nums, 2, 1);
        System.out.println(ret);
    }


}