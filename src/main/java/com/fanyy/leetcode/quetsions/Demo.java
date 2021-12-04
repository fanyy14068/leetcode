package com.fanyy.leetcode.quetsions;

/**
 * @author fanyuanyuan
 * @data 12/1/21
 */

public class Demo {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(a.length);
        System.out.println(a[0].length);

        System.out.println(pow(2, 10));
    }

    public static int pow(int a, int n) {
        int r = 1;
        while(n > 0) {
            if ((n & 1) == 1) {
                r = r * a;
            }
            n >>= 1;
            a = a*a;
        }
        return r;
    }


}
