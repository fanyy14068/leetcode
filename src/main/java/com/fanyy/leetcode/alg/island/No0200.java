package com.fanyy.leetcode.alg.island;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fanyuanyuan
 * @data 12/7/21
 * 岛屿问题：　给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * DFS算法（深度优先): 找到一个岛屿，然后四个方向遍历，把所有遍历过的点标记为０即可
 */

public class No0200 {
    static class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int nums = 0;
            int m = grid.length;
            int n = grid[0].length;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(grid[i][j] == '1') {
                        nums += 1;
                        bfs(grid, i, j);
//                        dfs(grid, i, j);
                    }
                }
            }
            return nums;
        }

        public void dfs(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i-1, j);
            dfs(grid, i+1, j);
            dfs(grid, i, j-1);
            dfs(grid, i, j+1);
        }

        public void bfs(char[][] grid, int i, int j) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {i, j});
            int[] px = {-1, 1, 0, 0};
            int[] py = {0, 0, -1, 1};
            grid[i][j] = '0';
            while(!queue.isEmpty()) {
                int[] cur = queue.remove();
                for(int k=0;k<4;k++) {
                    int x = cur[0] + px[k];
                    int y = cur[1] + py[k];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
                        continue;
                    }
                    grid[x][y] = '0';
                    queue.add(new int[] {x, y});
                }
            }
        }

//        public void bfs(char[][] grid, int i, int j) {
//            Queue<int[]> queue = new LinkedList<>();
//            queue.add(new int[] {i, j});
//            while(!queue.isEmpty()) {
//                int[] cur = queue.remove();
//                int p = cur[0], q = cur[1];
//                if (p >= 0 && p < grid.length && q >= 0 && q < grid[0].length && grid[p][q] == '1') {
//                    grid[p][q] = '0';
//                    queue.add(new int[] {p+1, q});
//                    queue.add(new int[] {p-1, q});
//                    queue.add(new int[] {p, q+1});
//                    queue.add(new int[] {p, q-1});
//                }
//            }
//        }

    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new Solution().numIslands(grid));
    }
}
