package com.fanyy.leetcode.dfs;

/**
 * @author: fanyy
 * Created on 2021/12/20
 */

public class No0130 {
    static class Solution {
        int n, m;

        public void solve(char[][] board) {
            n = board.length;
            if (n == 0) {
                return;
            }
            m = board[0].length;
            for (int i = 0; i < n; i++) {
                dfs(board, i, 0);
                dfs(board, i, m - 1);
            }
            for (int i = 1; i < m - 1; i++) {
                dfs(board, 0, i);
                dfs(board, n - 1, i);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
                return;
            }
            board[x][y] = 'A';
            dfs(board, x + 1, y);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }
    }

    public static void main(String[] args) {
        char[][] boards =  {{'X','O','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new Solution().solve(boards);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(boards[i][j] + " ");
            }
            System.out.println();
        }
    }
}