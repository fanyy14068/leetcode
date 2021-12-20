package com.fanyy.leetcode.back;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fanyy
 * Created on 2021/12/20
 */

public class No0078 {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> ret = new ArrayList<>();
            dfs(ans, ret, nums, 0);
            return ans;
        }

        public void dfs(List<List<Integer>> ans, List<Integer> ret, int[] nums, int i) {
            if (i == nums.length) {
                ans.add(new ArrayList<Integer> (ret));
                return;
            }
            ret.add(nums[i]);
            dfs(ans, ret, nums, i+1);
            ret.remove(ret.size() - 1);
            dfs(ans, ret, nums, i+1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = new Solution().subsets(nums);
        System.out.println(ans);
    }
}