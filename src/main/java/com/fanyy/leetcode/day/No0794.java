package com.fanyy.leetcode.day;

/**
 * @author fanyuanyuan
 * @data 12/9/21
 */

public class No0794 {
    static class Solution {
        public boolean validTicTacToe(String[] board) {
            // 规则: X >= O; 当有一条线练成的时候，游戏结束，没有其他的线练成(最多会有两条线)
            int count1 = 0;
            int count2 = 0;
            int line1 = 0;
            int line2 = 0;
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    if (board[i].charAt(j) == 'X') {
                        count1 += 1;
                    } else if (board[i].charAt(j) == 'O') {
                        count2 += 1;
                    }
                }
            }


            for(int i=0;i<3;i++) {
                if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(0) == board[i].charAt(2)) {
                    if (board[i].charAt(0) == 'X') {
                        line1 += 1;
                    } else if(board[i].charAt(0) == 'O'){
                        line2 += 1;
                    }
                }

                if (board[0].charAt(i) == board[1].charAt(i) && board[0].charAt(i) == board[2].charAt(i)) {
                    if (board[0].charAt(i) == 'X') {
                        line1 += 1;
                    } else if (board[0].charAt(i) == 'O') {
                        line2 += 1;
                    }
                }
            }

            boolean xWin = win(board, 'X');
            boolean yWin = win(board, 'O');

            if (xWin && yWin) {
                return false;
            }

            if (xWin && count2 == count1) {
                return false;
            }

            if (yWin && count1 > count2) {
                return false;
            }

            return count1 >= count2 && count2 >= (count1 - 1);

        }


        public boolean win(String[] board, char p) {
            for (int i = 0; i < 3; ++i) {
                if (p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) {
                    return true;
                }
                if (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2)) {
                    return true;
                }
            }
            if (p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) {
                return true;
            }
            if (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)) {
                return true;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        String[] boards = new String[] {"XO ", "   ", "X  "};
        System.out.println(new Solution().validTicTacToe(boards));
    }
}
