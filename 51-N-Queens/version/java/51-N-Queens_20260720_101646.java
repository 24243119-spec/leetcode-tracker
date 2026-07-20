// Last updated: 7/20/2026, 10:16:46 AM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<String>> solveNQueens(int n) {
7        List<List<String>> result = new ArrayList<>();
8        char[][] board = new char[n][n];
9        for (int i = 0; i < n; i++) {
10            Arrays.fill(board[i], '.');
11        }
12
13        boolean[] cols = new boolean[n];
14        boolean[] diag1 = new boolean[2 * n]; // row - col + n
15        boolean[] diag2 = new boolean[2 * n]; // row + col
16
17        backtrack(0, n, board, cols, diag1, diag2, result);
18        return result;
19    }
20
21    private void backtrack(int row, int n, char[][] board, boolean[] cols, boolean[] diag1, boolean[] diag2, List<List<String>> result) {
22        if (row == n) {
23            result.add(constructBoard(board));
24            return;
25        }
26
27        for (int col = 0; col < n; col++) {
28            int d1 = row - col + n;
29            int d2 = row + col;
30
31            if (cols[col] || diag1[d1] || diag2[d2]) {
32                continue;
33            }
34
35            board[row][col] = 'Q';
36            cols[col] = true;
37            diag1[d1] = true;
38            diag2[d2] = true;
39
40            backtrack(row + 1, n, board, cols, diag1, diag2, result);
41
42            // Backtrack
43            board[row][col] = '.';
44            cols[col] = false;
45            diag1[d1] = false;
46            diag2[d2] = false;
47        }
48    }
49
50    private List<String> constructBoard(char[][] board) {
51        List<String> res = new ArrayList<>();
52        for (char[] row : board) {
53            res.add(new String(row));
54        }
55        return res;
56    }
57}