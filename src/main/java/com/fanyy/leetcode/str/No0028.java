package com.fanyy.leetcode.str;

import com.fanyy.leetcode.dp.Solution0032;

import java.util.Arrays;

/**
 * @author fanyuanyuan
 * @data 12/16/21
 * 字符串匹配算法总结
 */

public class No0028 {

    static class Solution {
        /**
         * 暴力解法(时间：25.00%，空间：37.95%)
         */
        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();
            boolean flag;
            for(int i=0;i<=n-m;i++) {
                flag = true;
                for(int j=0;j<m;j++) {
                   if (haystack.charAt(i+j) != needle.charAt(j)) {
                       flag = false;
                       break;
                   }
                }
                if (flag) {
                   return i;
                }
            }
            return -1;
        }


        public int bm(String haystack, String needle) {
            if (needle.isEmpty()) {
                return 0;
            }
            if (haystack.isEmpty()) {
                return -1;
            }
            int r = 256;
            int[] bc = new int[r];  // bc记录haystack中每个字符出现的最后位置
            int m = needle.length();
            int n = haystack.length();
            buildBC(bc, needle, m);
            int skip = 0;
            for(int i=0;i<=n-m;i+=skip) {
                int j = m-1;
                while(j>=0 && needle.charAt(j) == haystack.charAt(i+j)) {
                    j--;
                }
                if (j < 0) {
                    return i;
                }
                skip = Math.max(1, j - bc[haystack.charAt(i+j)]);
            }
            return -1;

        }

        // 坏字符规则
        public void buildBC(int[] bc, String needle, int m) {
            Arrays.fill(bc, -1);
            for(int i=0;i<m;i++) {
                int ascii = needle.charAt(i);
                bc[ascii] = i;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().strStr("a", "a"));
        System.out.println(new Solution().bm("mississippi", "issi"));
        System.out.println(new Solution().bm("hello", "ll"));

    }
}
