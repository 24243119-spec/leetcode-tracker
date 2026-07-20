// Last updated: 7/20/2026, 10:12:32 AM
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, r, c, ch)) {
                            board[r][c] = ch;
                            
                            if (solve(board)) {
                                return true;
                            }
                            
                            // Backtrack
                            board[r][c] = '.';
                        }
                    }
                    return false; // No valid character fits here
                }
            }
        }
        return true; // Solved
    }
    
    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == ch) return false;
            // Check column
            if (board[i][col] == ch) return false;
            // Check 3x3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == ch) return false;
        }
        return true;
    }
}