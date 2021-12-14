package com.fanyy.leetcode;

import java.util.*;

/**
 * @author: fanyy
 * Created on 2021/12/10
 */

public class Demo {
    public static void main(String[] args) {
        int x = 4;
        while(x > 0) {
            int rx = x & 1;
            x >>= 1;
        }

    }
}
