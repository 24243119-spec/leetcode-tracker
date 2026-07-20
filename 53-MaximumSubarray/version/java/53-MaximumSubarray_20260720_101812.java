// Last updated: 7/20/2026, 10:18:12 AM
1class Solution {
2    public int maxSubArray(int[] nums) {
3        int maxSoFar = nums[0];
4        int currentMax = nums[0];
5
6        for (int i = 1; i < nums.length; i++) {
7            // Decide whether to extend the existing subarray or start a new subarray at nums[i]
8            currentMax = Math.max(nums[i], currentMax + nums[i]);
9            // Update the global maximum subarray sum found so far
10            maxSoFar = Math.max(maxSoFar, currentMax);
11        }
12
13        return maxSoFar;
14    }
15}