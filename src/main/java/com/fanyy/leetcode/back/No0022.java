package com.fanyy.leetcode.back;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanyuanyuan
 * @data 12/14/21
 * //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：n = 3
 * //输出：["((()))","(()())","(())()","()(())","()()()"]
 */

public class No0022 {
    static class Solution {
        /**
         * 递归生成子问题
         */

        ArrayList[] cache = new ArrayList[100];
        public List<String> generateParenthesis(int n) {

            List<String> combinations = new ArrayList<String>();
//            generateAll(new char[2 * n], 0, combinations);
//            backtrack(combinations, new StringBuilder(), 0, 0, n);
            combinations = generatorN(n);
            return combinations;
        }

        /**
         * 生成所有的序列，判断合法的
         * @param current
         * @param pos
         * @param result
         */
        public void generateAll(char[] current, int pos, List<String> result) {
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            } else {
                current[pos] = '(';
                generateAll(current, pos + 1, result);

                current[pos] = ')';
                generateAll(current, pos + 1, result);
            }
        }

        public boolean valid(char[] current) {
            int b = 0;
            for(int i = 0;i<current.length;i++) {
                if (current[i] == '(') {
                    b += 1;
                } else {
                    b -= 1;
                }
                if (b < 0) {
                    return false;
                }
            }
            return b == 0;
        }


        public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            if (open < max) {
                cur.append('(');
                backtrack(ans, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }


        /**
         * 任何一个括号序列都一定由'('开头，并且第一个'('有一个唯一与之对应的')', 因此可以用(a)b表示，其中a和b都是有效的括号
         * @param n
         * @return
         */
        public List<String> generatorN(int n) {
            if (cache[n] != null) {
                return cache[n];
            }
            ArrayList<String> ans = new ArrayList<String>();
            if (n == 0) {
                ans.add("");
            }
            for(int i=0;i<n;i++) {
                for(String left: generatorN(i)) {
                    for(String right: generatorN(n-i-1)) {
                        ans.add("(" + left + ")"  + right);
                    }
                }
            }
            cache[n] = ans;
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> str = new Solution().generateParenthesis(n);
        System.out.println(str.size());
        for(String s: str) {
            System.out.println(s);
        }
    }
}
