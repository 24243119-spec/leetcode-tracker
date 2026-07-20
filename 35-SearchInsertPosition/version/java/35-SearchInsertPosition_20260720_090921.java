// Last updated: 7/20/2026, 9:09:21 AM
1class Solution {
2    public boolean isValidSudoku(char[][] board) {
3        boolean[][] rows = new boolean[9][9];
4        boolean[][] cols = new boolean[9][9];
5        boolean[][] boxes = new boolean[9][9];
6        
7        for (int r = 0; r < 9; r++) {
8            for (int c = 0; c < 9; c++) {
9                if (board[r][c] == '.') {
10                    continue;
11                }
12                
13                int val = board[r][c] - '1'; // Convert '1'-'9' to index 0-8
14                int boxIndex = (r / 3) * 3 + (c / 3);
15                
16                // If value already exists in row, col, or 3x3 box, it's invalid
17                if (rows[r][val] || cols[c][val] || boxes[boxIndex][val]) {
18                    return false;
19                }
20                
21                // Mark value as seen
22                rows[r][val] = true;
23                cols[c][val] = true;
24                boxes[boxIndex][val] = true;
25            }
26        }
27        
28        return true;
29    }
30}