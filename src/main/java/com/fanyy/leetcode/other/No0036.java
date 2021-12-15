package com.fanyy.leetcode.other;

/**
 * @author: fanyy
 * Created on 2021/12/15
 */

public class No0036 {
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean[][] rows = new boolean[9][9];
            boolean[][] cols = new boolean[9][9];
            boolean[][] subbox = new boolean[9][9];
            for(int i=0;i<9;i++) {
                for(int j=0;j<9;j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    char c = board[i][j];
                    int index = c - '0' - 1;
                    if (rows[i][index]) {
                        return false;
                    }
                    rows[i][index] = true;

                    if (cols[j][index]) {
                        return false;
                    }
                    cols[j][index] = true;

                    int boxId = i / 3 * 3 + j / 3;
                    if (subbox[boxId][index]) {
                        return false;
                    }
                    subbox[boxId][index] = true;

                }
            }
            return true;
        }
    }
}