package com.fanyy.leetcode.binarytree;

import java.util.*;
/**
 * @author: fanyy
 * Created on 2021/12/16
 */

public class No1610
{
    static class Solution{
        public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
            int ans = 0;
            List<Double> polarDegree = new ArrayList<>();
            int lx = location.get(0);
            int ly = location.get(1);
            for(int i=0;i<points.size();i++) {
                int x = points.get(i).get(0);
                int y = points.get(i).get(1);
                if (x == lx && y == ly) {
                    ans += 1;
                    continue;
                }
                Double degree = Math.atan2(y - ly, x - lx);
                polarDegree.add(degree);
            }
            Collections.sort(polarDegree);

            int m = polarDegree.size();
            for(int i=0;i<m;i++) {
                polarDegree.add(polarDegree.get(i) + 2 * Math.PI);
            }

            int maxCnt = 0;
            Double toDegree = angle * Math.PI / 180;
            for(int i=0;i<m;i++) {
                int it = binarySearch(polarDegree, polarDegree.get(i) + toDegree, false);
                maxCnt = Math.max(maxCnt, it - i);
            }
            return ans + maxCnt;

        }

        public int binarySearch(List<Double> nums, Double target, boolean lower) {
            int left = 0, right = nums.size() - 1;
            int ans = nums.size();
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if (nums.get(mid) > target || (lower && nums.get(mid) >= target)) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<>();
        points.add(Arrays.asList(2, 1));
        points.add(Arrays.asList(2, 2));
        points.add(Arrays.asList(3, 3));
        List<Integer> location = Arrays.asList(1, 1);
        int degree = 90;
        System.out.println(new Solution().visiblePoints(points, degree, location));
    }
}