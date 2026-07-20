// Last updated: 7/20/2026, 10:18:52 AM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<Integer> spiralOrder(int[][] matrix) {
6        List<Integer> result = new ArrayList<>();
7        if (matrix == null || matrix.length == 0) {
8            return result;
9        }
10
11        int top = 0;
12        int bottom = matrix.length - 1;
13        int left = 0;
14        int right = matrix[0].length - 1;
15
16        while (top <= bottom && left <= right) {
17            // 1. Traverse Right across the top row
18            for (int col = left; col <= right; col++) {
19                result.add(matrix[top][col]);
20            }
21            top++;
22
23            // 2. Traverse Down along the rightmost column
24            for (int row = top; row <= bottom; row++) {
25                result.add(matrix[row][right]);
26            }
27            right--;
28
29            // 3. Traverse Left across the bottom row
30            if (top <= bottom) {
31                for (int col = right; col >= left; col--) {
32                    result.add(matrix[bottom][col]);
33                }
34                bottom--;
35            }
36
37            // 4. Traverse Up along the leftmost column
38            if (left <= right) {
39                for (int row = bottom; row >= top; row--) {
40                    result.add(matrix[row][left]);
41                }
42                left++;
43            }
44        }
45
46        return result;
47    }
48}