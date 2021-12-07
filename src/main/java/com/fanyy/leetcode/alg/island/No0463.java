package com.fanyy.leetcode.alg.island;

/**
 * @author fanyuanyuan
 * @data 12/7/21
 */

public class No0463 {
    static class Solution {
        public int islandPerimeter(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int per = 0;
            int m = grid.length;
            int n = grid[0].length;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(grid[i][j] == 1) {
                        per += dfs(grid, i, j);
                    }
                }
            }
            return per;

        }

        public int dfs(int[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
                return 1;
            } else if (grid[i][j] == 2) {
                return 0;
            }
            int ret = 0;
            grid[i][j] = 2;
            ret += dfs(grid, i-1, j);
            ret += dfs(grid, i+1, j);
            ret += dfs(grid, i, j-1);
            ret += dfs(grid, i, j+1);
            return ret;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(new Solution().islandPerimeter(grid));

    }
}
