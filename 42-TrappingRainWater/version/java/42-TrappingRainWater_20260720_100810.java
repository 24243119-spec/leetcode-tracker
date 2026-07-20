// Last updated: 7/20/2026, 10:08:10 AM
1class Solution {
2    public int trap(int[] height) {
3        if (height == null || height.length == 0) {
4            return 0;
5        }
6        
7        int left = 0;
8        int right = height.length - 1;
9        int leftMax = 0;
10        int rightMax = 0;
11        int totalWater = 0;
12        
13        while (left < right) {
14            if (height[left] < height[right]) {
15                if (height[left] >= leftMax) {
16                    leftMax = height[left];
17                } else {
18                    totalWater += leftMax - height[left];
19                }
20                left++;
21            } else {
22                if (height[right] >= rightMax) {
23                    rightMax = height[right];
24                } else {
25                    totalWater += rightMax - height[right];
26                }
27                right--;
28            }
29        }
30        
31        return totalWater;
32    }
33}