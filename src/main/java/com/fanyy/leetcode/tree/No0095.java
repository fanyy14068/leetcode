package com.fanyy.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanyuanyuan
 * @data 12/12/21
 * //给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * //
 * //
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：n = 3
 * //输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * //
 */

public class No0095 {
    static class TreeNode {
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
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            return generateTree(1, n);
        }

        public List<TreeNode> generateTree(int start, int end) {
            List<TreeNode> ret = new ArrayList<>();
            if (start > end) {
                ret.add(null);
                return ret;
            }

            for(int i=start;i<=end;i++) {
                List<TreeNode> left = generateTree(start, i-1);
                List<TreeNode> right = generateTree(i+1, end);
                for(TreeNode l: left) {
                    for(TreeNode r: right) {

                        TreeNode node = new TreeNode(i);
                        node.left = l;
                        node.right = r;
                        ret.add(node);
                    }

                }
            }

            return ret;
        }

        public void show(TreeNode node) {
            if (node == null) {
                return;
            }
            System.out.print(node.val + " ");
            show(node.left);
            show(node.right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(4);
        System.out.println(treeNodes.size());
        for(TreeNode n: treeNodes) {
            solution.show(n);
            System.out.println();
        }
    }
}
