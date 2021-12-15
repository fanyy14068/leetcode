package com.fanyy.leetcode.back;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: fanyy
 * Created on 2021/12/15
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */

public class No0046 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> output = new ArrayList<>();
            for(int i: nums) {
                output.add(i);
            }
            dfs(nums.length, ans,output, 0);
            return ans;

        }

        public void dfs(int n, List<List<Integer>> ans, List<Integer> output, int index) {
            if (index == n) {;
                ans.add(new ArrayList<>(output));
                return;
            }

            for(int i=index;i<n;i++) {
                Collections.swap(output, index, i);
                dfs(n, ans, output, index+1);
                Collections.swap(output, index, i);
            }

        }
    }
}