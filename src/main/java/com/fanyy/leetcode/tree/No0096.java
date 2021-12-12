package com.fanyy.leetcode.tree;

/**
 * @author fanyuanyuan
 * @data 12/12/21
 * G(n): 长度为ｎ的序列能够成的数量，f(i,n)以i为根
 * f(i, n) = G(i-1)*G(n-i)
 */

public class No0096 {

    static class Solution {
        public int numTrees(int n) {
            if (n <= 1) {
                return n;
            }
            int[] a = new int[n+1];
            a[0] = 1;
            a[1] = 1;
            for(int i=2;i<=n;i++) {
                for(int j=1;j<=i;j++) {
                    a[i] += a[j-1] * a[i-j];
                }
            }
            return a[n];
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
}
