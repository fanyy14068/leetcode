package com.fanyy.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fanyuanyuan
 * @data 12/9/21
 */

public class Sword0009 {
    class CQueue {

        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();

        }

        public void appendTail(int value) {
            stack1.push(value);

        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            if (stack2.isEmpty()) {
                return -1;
            }

            return stack2.pop();
        }
    }
}
