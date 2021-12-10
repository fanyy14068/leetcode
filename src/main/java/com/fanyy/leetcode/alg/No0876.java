package com.fanyy.leetcode.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fanyy
 * Created on 2021/12/9
 */

public class No0876 {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {


        public ListNode middleNode1(ListNode head) {
            int n = 0;
            ListNode tmp =  head;
            while(tmp != null) {
                n += 1;
                tmp = tmp.next;
            }

            int c = 0;
            ListNode ret = head;

            while ( c < (n/2)) {
                c += 1;
                ret = ret.next;
            }
            return ret;


        }

        /**
         * 快慢指针
         * @param head
         * @return
         */
        public ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }


    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = new ListNode();
        ListNode tmp = head;
        for(int i: nums) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        ListNode mid = new Solution().middleNode(head.next);
        while(mid != null) {
            System.out.println(mid.val);
            mid = mid.next;
        }
    }
}