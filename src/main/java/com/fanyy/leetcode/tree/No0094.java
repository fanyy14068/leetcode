package com.fanyy.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanyuanyuan
 * @data 12/12/21
 */

public class No0094 {
    public class TreeNode {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            if (root == null) {
                return ret;
            }
            ret.addAll(inorderTraversal(root.left));
            ret.add(root.val);
            ret.addAll(inorderTraversal(root.right));
            return ret;
        }
    }
}
