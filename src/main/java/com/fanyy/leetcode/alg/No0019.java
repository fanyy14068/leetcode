package com.fanyy.leetcode.alg;

/**
 * @author: fanyy
 * Created on 2021/12/9
 */

public class No0019 {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution{
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode head0 = new ListNode();
            head0.next = head;
            ListNode fast = head0;
            ListNode slow = head0;

            int i = 0;
            while(fast.next != null) {
                fast = fast.next;
                i += 1;
                if (i >= n + 1) {
                    slow = slow.next;
                }
            }
            ;

            if (slow.next != null) {
                slow.next = slow.next.next;
            } else {
                slow.next = null;
            }


            return head0.next;

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
        ListNode mid = new Solution().removeNthFromEnd(head.next, 2);
        while(mid != null) {
            System.out.println(mid.val);
            mid = mid.next;
        }
    }


}
