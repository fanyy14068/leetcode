package com.fanyy.leetcode.other;

/**
 * @author fanyuanyuan
 * @data 12/4/21
 * No.0009
 * 需要考虑异常情况
 */

public class No0009 {
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x%10==0 && x !=0)) {
                return false;
            }
            int y = 0;
            while ( x > y) {  // 分长度奇偶，到一半就可以
                y = y * 10 + x % 10;
                x /= 10;
            }
            return x == y || x == y / 10;

//            while(x > 9) {
//                y = y * 10 + x % 10;
//                x /= 10;
//            }
//            return (z - x) / 10 == y;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}
