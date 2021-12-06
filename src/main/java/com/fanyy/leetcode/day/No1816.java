package com.fanyy.leetcode.day;

/**
 * @author fanyuanyuan
 * @data 12/6/21
 */


public class No1816 {
    static class Solution {
        /**
         * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）
         * 给你一个句子 s​​​​​​ 和一个整数 k​​​​​​ ，请你将 s​​ 截断 ​，​​​使截断后的句子仅含 前 k​​​​​​ 个单词。返回 截断 s​​​​​​ 后得到的句子。
         * todo: 注意边界条件，最后一个单词是第k个场景

         * @param s
         * @param k
         * @return
         */
        public String truncateSentence(String s, int k) {
            int c = 0;
            int end = 0;
            while ( c < k && end < s.length()) {
                if (s.charAt(end) == ' ') {
                    c += 1;
                }
                end ++;
            }
            if (c == k) {
                end --;
            }
            return s.substring(0, end);
        }

    }

    public static void main(String[] args) {
        String s = "chopper is not a tanuki";
        Integer k = 5;
        System.out.println(new Solution().truncateSentence(s, k) + "|");
    }
}
