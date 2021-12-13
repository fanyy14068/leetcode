package com.fanyy.leetcode;

import java.util.*;

/**
 * @author: fanyy
 * Created on 2021/12/10
 */

public class Demo {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 8, 33, 0, 9, 27,66, 88};
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int[] a = {0, 9, 27, 66, 88};
        while(p1 < 5 && p2 < 5) {
            if (nums[p1] <= a[p2]) {
                nums[p3++] = nums[p1++];
            } else {
                nums[p3++] = a[p2++];
            }
        }

        while(p1 < 5) {
            nums[p3++] = nums[p1++];
        }

        while(p2 < 5) {
            nums[p3++] = a[p2++];
        }

        for(int i: nums ) {
            System.out.println(nums[i] + " ");
        }

    }
}
