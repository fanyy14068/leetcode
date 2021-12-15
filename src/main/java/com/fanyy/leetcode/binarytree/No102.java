package com.fanyy.leetcode.binarytree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author fanyuanyuan
 * @data 12/14/21
 */

public class No102 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {


            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);

            while(!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int currentLevelSize = queue.size();
                for(int i=1;i<=currentLevelSize;i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                ans.add(level);

            }

            return ans;

        }

        /**
         * 创建树，需要用递归
         */
        public  TreeNode buildTree(Integer[] nums, int index) {
            if (index > nums.length - 1) {
                return null;
            }
            Integer value = nums[index];
            if (value == null) {
                return null;
            }
            TreeNode node = new TreeNode(value);
            node.left = buildTree(nums, 2*index+1);
            node.right = buildTree(nums, 2*index + 2);
            return node;

        }
    }




    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        Solution solution = new Solution();
        TreeNode node = solution.buildTree(nums, 0);

        List<List<Integer>> ret = solution.levelOrder(node);
        for(List<Integer> list: ret) {
            System.out.println(list);
        }
    }


}
