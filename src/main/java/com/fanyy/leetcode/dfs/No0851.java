package com.fanyy.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fanyy
 * Created on 2021/12/15
 */

public class No0851 {
    static class Solution {
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            int n = quiet.length;
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; ++i) {
                g[i] = new ArrayList<Integer>();
            }
            for (int[] r : richer) {
                g[r[1]].add(r[0]);
            }

            int[] ans = new int[n];
            Arrays.fill(ans, -1);

            for(int i=0;i<ans.length;i++) {
                dfs(g, quiet, i, ans);
            }
            return ans;

        }

        public void dfs(List<Integer>[] g, int[] quiet, Integer x, int[] ans) {
            if (ans[x] != -1) {
                return;
            }
            ans[x] = x;
            for(int y: g[x]) {
                dfs(g, quiet, y, ans);
                if (quiet[ans[y]] < quiet[ans[x]]) {
                    ans[x] = ans[y];
                }
            };
        }
    }

    public static void main(String[] args) {
        int[][] ranchers =
                {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quite = {3,2,5,4,6,1,7,0};
        int[] ret = new Solution().loudAndRich(ranchers, quite);
        for(int i: ret) {
            System.out.print(i + " ");
        }
    }
}