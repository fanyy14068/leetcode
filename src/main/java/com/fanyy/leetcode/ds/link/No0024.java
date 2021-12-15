package com.fanyy.leetcode.ds.link;

import com.fanyy.leetcode.ds.ListNode;

/**
 * @author: fanyy
 * Created on 2021/12/15
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 */

public class No0024 {
    class Solution {
        public ListNode swapPairs(ListNode head) {


            ListNode ans = new ListNode();
            ans.next = head;
            ListNode tmp = ans;

            while(tmp.next != null && tmp.next.next != null) {
                ListNode node1 = tmp.next;
                ListNode node2 = tmp.next.next;

                tmp.next = node2;
                node1.next = node2.next;
                node2.next = node1;
                tmp = node1;

            }

            return ans.next;
        }
    }
}