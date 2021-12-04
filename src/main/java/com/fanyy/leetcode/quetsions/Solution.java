package com.fanyy.leetcode.quetsions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author fanyuanyuan
 * @data 12/1/21
 */

public class Solution {


    /*
        No. 1446
        给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
     */
    public int maxPower(String s) {
        if (s.length() <= 1) {
            return 1;
        }

        int ret = 1;
        int cur_len = 1;
        char cur_s = s.charAt(0);
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i) == cur_s ) {
                cur_len += 1;
                if (cur_len > ret) {
                    ret = cur_len;
                }
            } else {
                cur_len = 1;
                cur_s = s.charAt(i);
            }
        }
        return ret;
    }

    /*
    No.1
    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    tip: hashMap
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ret = {};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                ret = new int[]{i, map.get(target - nums[i])};
                return ret;
            } else {
                map.put(nums[i], i);
            }
        }
        return ret;
    }


    /*
    No.2
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        Integer tmp = 0;
        while(l1 != null || l2 != null) {
            int s = tmp;
            if (l1 != null) {
                s += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                s += l2.val;
                l2 = l2.next;
            }
            if (s >= 10) {
                tmp = 1;
                cur.next = new ListNode(s%10);
            } else {
                tmp = 0;
                cur.next = new ListNode(s);
            }
            cur = cur.next;
        }

        if (tmp != 0) {
            cur.next = new ListNode(tmp);
        }
        return head.next;
    }

    /*
    No.5
    给你一个字符串 s，找到 s 中最长的回文子串。
    tips: 动态规划; 中心扩散
     */
    public String longestPalindrome(String s) {
//        int n = s.length();
//        if (n <= 1) {
//            return s;
//        }
//
//        boolean[][] arr = new boolean[n][n];
//        int left = 0;
//        int right = 0;
//        for (int i=0;i<n;i++) {
//            arr[i][i] = true;
//        }
//        for (int k=2; k<=n; k++) {
//            for(int i=0;i<n-k+1;i++) {
//                boolean b = s.charAt(i) == s.charAt(i+k-1);
//                if (k==2) {
//                    arr[i][i+k-1] = b;
//                } else {
//                    arr[i][i+k-1] = b && arr[i+1][i+k-2];
//                }
//                if (arr[i][i+k-1]) {
//                    left = i;
//                    right = i+k-1;
//                }
//            }
//        }
//
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<n;j++){
//                System.out.print(arr[i][j] + "\t");
//            }
//            System.out.print("\n");
//        }
//
//        return s.substring(left, right+1);

        int n = s.length();
        if (n <= 1) {
            return s;
        }
        int max = 1;
        int left = 0;
        for (int i=0;i<n-1;i++) {
            int l1 = expandAroundCenter(s, i, i); // 以i为中心，找最长的回文串
            int l2 = expandAroundCenter(s, i, i + 1);
            if (l1 >= l2 && l1 > max) {
                left = i - l1 / 2;
                max = l1;
            } else if (l2 > l1 && l2 > max) {
                left = i - l2 / 2 + 1;
                max = l2;
            }
        }
        return s.substring(left, left + max);

    }

    public int expandAroundCenter(String s, int i, int j) {
        while(true) {
            if ( i < 0 || j  >= s.length() || s.charAt(i) != s.charAt(j)) {
                break;
            }
            i -= 1;
            j += 1;
        }
        return j - i - 1;
    }

    /*
    No.506
     */
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Gold Medal");
        map.put(1, "Silver Medal");
        map.put(2, "Bronze Medal");
        String[] ret = new String[score.length];
        int n = score.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        for(int i=0;i<n;i++) {
            Integer k = i + 1;
            ret[arr[i][1]] = map.getOrDefault(i, k.toString());
        }
        return ret;
    }

    /*
    No.263 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
    丑数 就是只包含质因数 2、3 和/或 5 的正整数
     */
    public boolean isUgly(int n) {
        int[] nums = {2, 3, 5};
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        for (int i: nums) {
            if (n % i == 0) {
                return isUgly(n/i);
            }
        }
        return false;

    }

    /*
    No.8
    * */
//    public int myAtoi(String s) {
//        if (s.length() < 1) {
//            return 0;
//        }
//        int ret = 0;
//
//        for(int i=0;i<s.length();i++) {
//            if (s.charAt(i)) {
//
//            }
//        }
//    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
