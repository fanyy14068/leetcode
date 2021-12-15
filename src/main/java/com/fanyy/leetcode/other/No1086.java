package com.fanyy.leetcode.other;

import java.util.*;

/**
 * @author fanyuanyuan
 * @data 12/13/21
 */

public class No1086 {
    static class Solution {
        public int[][] highFive(int[][] items) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i=0;i<items.length;i++) {
                int student = items[i][0];
                int score = items[i][1];

                if (map.containsKey(student)) {
                    map.get(student).add(score);
                } else {
                    List<Integer> scores = new ArrayList<>();
                    scores.add(score);
                    map.put(student, scores);
                }
            }

            int[][] ret = new int[map.size()][2];
            int c=0;
            for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
                ret[c][0] = entry.getKey();
                ret[c][1] = avgTop5(entry.getValue());
                c += 1;
            }
            return ret;
        }

        public int avgTop5(List<Integer> list) {
            Collections.sort(list);
            int count = 0;
            int sum = 0;
            for(int i=list.size()-1;i>=0;i++) {
                count += 1;
                sum += list.get(i);
                if (i >= 5) {
                    break;
                }
            }

            return sum / count;
        }
    }
}
