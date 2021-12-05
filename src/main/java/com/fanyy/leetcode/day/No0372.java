package com.fanyy.leetcode.day;

/**
 * @author fanyuanyuan
 * @data 12/4/21
 * No.0372
 * 快速幂， 然后需要找到递推关系
 */

public class No0372 {
    static class Solution{
        public int superPow(int a, int[] b) {
            int k = a % 1337;
            int n = b.length;
            int t = k;
            int ret = 1;
            for(int i=n-1;i>=0;i--) {
                ret = (ret * subPow(t, b[i])) % 1337;
                t = subPow(t, 10);
            }
            return ret;

        }

        public int subPow(int tmp, int n) {
            int ret = 1;
            while (n > 0) {
                if ((n&1) == 1) {
                    ret = (ret * tmp) % 1337;
                }
                tmp = tmp * tmp % 1337;
                n >>= 1;
            }
            return ret;
        }



    }

    public static void main(String[] args) {
        int a1 = 78267 ;
        int[] b1 = {2, 0, 0};
//        System.out.println(new Solution().superPow(a1, b1));
        System.out.println(new Solution().superPow(a1, b1));


    }
}
