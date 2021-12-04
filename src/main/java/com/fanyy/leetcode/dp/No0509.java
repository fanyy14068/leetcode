package com.fanyy.leetcode.dp;

/**
 * @author fanyuanyuan
 * @data 12/4/21
 * 斐波那契数(No.509, No.1137)
 */

public class No0509 {
    static class Solution {
        /**
        　* 直接思路：动态规划
         * */
        public int fib(int n) {
            if (n <= 1) {
                return n;
            }
            int a0 = 0;
            int a1 = 1;
            int an = 1;

            for(int i=2;i<=n;i++) {
                an = a0 + a1;
                a0 = a1;
                a1 = an;
            }
            return an;
        }

        /**
         * 快速幂算法，求n次方可以通过二分法
         * @param n
         * @return
         */
        public int fib2(int n) {
            if (n <= 1) {
                return n;
            }
            int[][] arr = {{1, 1}, {1, 0}};
            int[][] powArr = pow(arr, n-1);
            return powArr[0][0];
        }

        public int[][] pow(int[][] arr, int n) {
            // 矩阵快速幂算法
            int[][] ret = new int[arr.length][arr.length];
            for(int i=0;i<arr.length;i++){
                ret[i][i] = 1;
            }
            while (n > 0) {
                if ((n & 1) == 1) {
                    ret = multiple(ret, arr);
                }
                n >>= 1;
                arr = multiple(arr, arr);
            }
            return ret;
        }

        public int[][] multiple(int[][] a, int[][] b) {
            // 矩阵乘法
            int m = a.length;
            int n = b[0].length;
            if (a[0].length != b[0].length) { // 错误的
                return new int[m][n];
            }
            int[][] ret = new int[a.length][b[0].length];
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    for (int k=0;k<a[0].length;k++) {
                        ret[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            return ret;
        }


    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib2(5));
    }
}
