// Last updated: 7/20/2026, 10:10:54 AM
1class Solution {
2    public int jump(int[] nums) {
3        int jumps = 0;
4        int currentEnd = 0;
5        int maxReach = 0;
6
7        // Loop up to nums.length - 1 because we don't need to jump from the last element
8        for (int i = 0; i < nums.length - 1; i++) {
9            maxReach = Math.max(maxReach, i + nums[i]);
10
11            // If we've reached the end of the current jump boundary
12            if (i == currentEnd) {
13                jumps++;
14                currentEnd = maxReach;
15
16                // Early exit if we can already reach or cross the end
17                if (currentEnd >= nums.length - 1) {
18                    break;
19                }
20            }
21        }
22
23        return jumps;
24    }
25}