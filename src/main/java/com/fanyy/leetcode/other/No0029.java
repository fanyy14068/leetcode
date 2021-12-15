package com.fanyy.leetcode.other;

/**
 * @author: fanyy
 * Created on 2021/12/15
 * 不用乘法/除法/mode运算符，实现整数相除
 */

public class No0029 {
    static class Solution {
        /**
         * Z > 0, X <0, Y < 0
         * Z×Y≥X>(Z+1)×Y
         * 找到这样的Z即可， 需要考虑边界
         */
        public int divide(int dividend, int divisor) {
            // 考虑特殊情况
            if(dividend == Integer.MIN_VALUE) {
                if (divisor == 1) {
                    return dividend;
                }
                if (dividend == -1) {
                    return Integer.MAX_VALUE;
                }
            }

            if (divisor == Integer.MIN_VALUE) {
                return dividend == Integer.MIN_VALUE ? 1 : 0;
            }

            if (dividend == 0) {
                return 0;
            }

            boolean rev = false;
            if (dividend > 0) {
                rev = !rev;
                dividend =  - dividend;
            }

            if (divisor > 0) {
                rev = !rev;
                divisor = -divisor;
            }
            int left = 1, right = Integer.MAX_VALUE, ans = 0;
            while(left <= right) {
                int mid = left + ((right - left) >> 1);
                boolean check = quickAdd(divisor, mid, dividend);
                if (check) {
                    ans = mid;
                    if (mid == Integer.MAX_VALUE) {
                        break;
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return rev ? -ans: ans;
        }

        public boolean quickAdd(int y, int z, int x) {
            // x, y 是复数，z是正数
            // 判断是否y * z >= x 是否成立
            int result = 0, add = y;
            while(z != 0) {
                if (( z & 1) != 0) {
                    if (result < x - add) {
                        return false;
                    }
                    result += add;
                }
                if (z != 1) {
                    if (add < x - add) {
                        return false;
                    }
                    add += add;
                }
                z >>= 1;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(new Solution().divide(5, 2));
    }
}