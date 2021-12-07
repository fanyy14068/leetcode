package com.fanyy.leetcode.alg.island;

/**
 * @author fanyuanyuan
 * @data 12/7/21
 * //给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色
 * //。
 * //
 * // 两个网格块属于同一 连通分量 需满足下述全部条件：
 * //
 * //
 * // 两个网格块颜色相同
 * // 在上、下、左、右任意一个方向上相邻
 * //
 * //
 * // 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 * //
 * //
 * // 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
 * // 在网格的边界上（第一行/列或最后一行/列）
 * //
 * //
 * // 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * //输出：[[3,3],[3,2]]
 * //
 * // 示例 2：
 * //
 * //
 * //输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * //输出：[[1,3,3],[2,3,3]]
 * //
 * // 示例 3：
 * //
 * //
 * //输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * //输出：[[2,2,2],[2,1,2],[2,2,2]]
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // m == grid.length
 * // n == grid[i].length
 * // 1 <= m, n <= 50
 * // 1 <= grid[i][j], color <= 1000
 * // 0 <= row < m
 * // 0 <= col < n
 * //
 * //
 * //
 * // Related Topics 深度优先搜索 广度优先搜索 数组 矩阵
 * // 👍 117 👎 0
 */

public class No1034 {
    static class Solution {
        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            int v = grid[row][col];
            int m = grid.length;
            int n = grid[0].length;
            dfs(grid, row, col, v);
            int[][] ret = new int[grid.length][grid[0].length];
            for(int i=0;i<grid.length;i++) {
                for(int j=0;j<grid[0].length;j++) {
                    if(grid[i][j] != 0) {
                        ret[i][j] = grid[i][j];
                    } else if (i==0 || j==0 || i==m-1 || j==n-1) {
                        ret[i][j] = color;
                    } else if (grid[i-1][j] == 0 && grid[i+1][j] == 0 && grid[i][j-1] ==0 && grid[i][j+1] == 0) {
                      ret[i][j] = v;
                    } else {
                        ret[i][j] = color;
                    }
                }
            }
            return ret;
        }

        public void dfs(int[][] grid, int x, int y, int v) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] != v) {
                return;
            }
            grid[x][y] = 0;
            dfs(grid, x-1, y, v);
            dfs(grid, x+1, y, v);
            dfs(grid, x, y-1, v);
            dfs(grid, x, y+1, v);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1},{1,2}};
        int[][] ret = new Solution().colorBorder(grid, 0, 0, 3);
        for(int i=0;i<ret.length;i++){
            for(int j=0;j<ret[0].length;j++) {
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }

    }
}
