package com.fanyy.leetcode.day;

import java.util.Arrays;

/**
 * @author: fanyy
 * Created on 2021/12/20
 */

public class No0475 {
    static class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            int ans = 0;
            Arrays.sort(heaters);
            for(int i=0;i<houses.length;i++) {
                int left = binarySearch(heaters, houses[i]);
                int right = left + 1;
                int leftDistance = left < 0 ? Integer.MAX_VALUE : houses[i] - heaters[left];
                int rightDistance = right >= heaters.length ? Integer.MAX_VALUE : heaters[right] - houses[i];
                ans = Math.max(ans, Math.min(leftDistance, rightDistance));
            }
            return ans;

        }

        public int binarySearch(int[] heaters, int house) {
            int left = 0, right = heaters.length - 1;
            if (heaters[left] > house) {
                return -1;
            }

            while(left < right) {
                int mid = left + (right - left + 1) / 2;
                if (heaters[mid] > house) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            return left;
        }
    }



}