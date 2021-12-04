package com.fanyy.leetcode.quetsions;

/**
 * @author fanyuanyuan
 * @data 12/1/21
 */

public class Demo {
    public static void main(String[] args) {
        int[] a= {10, 3, 8, 9, 4};
        String[] b = new Solution().findRelativeRanks(a);
        for (String i: b) {
            System.out.println(i);
        }
    }


    public static ListNode transToListNode(int[] nums) {
        ListNode head = new ListNode();
        ListNode node = head;
        for(int i: nums) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return head.next;
    }


}
