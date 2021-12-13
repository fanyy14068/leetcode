package com.fanyy.leetcode.ds;

import java.util.Stack;

/**
 * @author fanyuanyuan
 * @data 12/13/21
 */

public class No0020 {
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if ((c - top) != 1 && (c - top) != 2) {  // Ascii码，()相差1,[]和{}都是相差2
                        return false;

                    }
                }
            }

            return stack.isEmpty();

        }
    }

    public static void main(String[] args) {
        boolean ret = new Solution().isValid("()[]{}");
        System.out.println(ret);
    }
}
