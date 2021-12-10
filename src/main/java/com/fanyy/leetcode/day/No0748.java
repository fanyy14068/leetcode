package com.fanyy.leetcode.day;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fanyy
 * Created on 2021/12/10
 */

public class No0748 {
    static class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            HashMap<Character, Integer> map = new HashMap<>();
            licensePlate = licensePlate.toLowerCase();
            for(int i=0;i<licensePlate.length();i++) {
                char t = licensePlate.charAt(i);
                if (t < 'a' || t > 'z') {
                    continue;
                }
                if (map.containsKey(t)) {
                    map.put(t, map.get(t) + 1);
                } else {
                    map.put(t, 1);
                }
            }

            String ret = "";
            int num = 15;
            for(String word: words) {
                if (isPlate(map, word) && word.length() < num) {
                    ret = word;
                    num = word.length();
                }
            }
            return ret;


        }

        public boolean isPlate(Map<Character, Integer> map1, String word) {
            Map<Character, Integer> map = new HashMap<>(map1);
            for(int i=0;i<word.length();i++) {
                char t = word.charAt(i);
                if (map.containsKey(t)) {
                    map.put(t, map.get(t) - 1 );
                }
            }

            for(Map.Entry<Character, Integer> entry: map.entrySet()) {
                if (entry.getValue() > 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String ret = new Solution().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
        System.out.print(ret);
    }
}