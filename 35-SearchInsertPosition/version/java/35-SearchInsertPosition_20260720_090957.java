// Last updated: 7/20/2026, 9:09:57 AM
1class Solution {
2    public void solveSudoku(char[][] board) {
3        solve(board);
4    }
5    
6    private boolean solve(char[][] board) {
7        for (int r = 0; r < 9; r++) {
8            for (int c = 0; c < 9; c++) {
9                if (board[r][c] == '.') {
10                    for (char ch = '1'; ch <= '9'; ch++) {
11                        if (isValid(board, r, c, ch)) {
12                            board[r][c] = ch;
13                            
14                            if (solve(board)) {
15                                return true;
16                            }
17                            
18                            // Backtrack
19                            board[r][c] = '.';
20                        }
21                    }
22                    return false; // No valid character fits here
23                }
24            }
25        }
26        return true; // Solved
27    }
28    
29    private boolean isValid(char[][] board, int row, int col, char ch) {
30        for (int i = 0; i < 9; i++) {
31            // Check row
32            if (board[row][i] == ch) return false;
33            // Check column
34            if (board[i][col] == ch) return false;
35            // Check 3x3 box
36            int boxRow = 3 * (row / 3) + i / 3;
37            int boxCol = 3 * (col / 3) + i % 3;
38            if (board[boxRow][boxCol] == ch) return false;
39        }
40        return true;
41    }
42}