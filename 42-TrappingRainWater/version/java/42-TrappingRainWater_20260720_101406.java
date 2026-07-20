// Last updated: 7/20/2026, 10:14:06 AM
1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4        
5        // Step 1: Transpose the matrix (swap matrix[i][j] with matrix[j][i])
6        for (int i = 0; i < n; i++) {
7            for (int j = i + 1; j < n; j++) {
8                int temp = matrix[i][j];
9                matrix[i][j] = matrix[j][i];
10                matrix[j][i] = temp;
11            }
12        }
13        
14        // Step 2: Reverse each row horizontally
15        for (int i = 0; i < n; i++) {
16            int left = 0;
17            int right = n - 1;
18            while (left < right) {
19                int temp = matrix[i][left];
20                matrix[i][left] = matrix[i][right];
21                matrix[i][right] = temp;
22                left++;
23                right--;
24            }
25        }
26    }
27}