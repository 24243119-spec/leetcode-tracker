// Last updated: 7/20/2026, 10:17:29 AM
1class Solution {
2    private int count = 0;
3
4    public int totalNQueens(int n) {
5        boolean[] cols = new boolean[n];
6        boolean[] diag1 = new boolean[2 * n]; // row - col + n
7        boolean[] diag2 = new boolean[2 * n]; // row + col
8
9        backtrack(0, n, cols, diag1, diag2);
10        return count;
11    }
12
13    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
14        if (row == n) {
15            count++;
16            return;
17        }
18
19        for (int col = 0; col < n; col++) {
20            int d1 = row - col + n;
21            int d2 = row + col;
22
23            if (cols[col] || diag1[d1] || diag2[d2]) {
24                continue;
25            }
26
27            // Place queen
28            cols[col] = true;
29            diag1[d1] = true;
30            diag2[d2] = true;
31
32            backtrack(row + 1, n, cols, diag1, diag2);
33
34            // Backtrack / Remove queen
35            cols[col] = false;
36            diag1[d1] = false;
37            diag2[d2] = false;
38        }
39    }
40}