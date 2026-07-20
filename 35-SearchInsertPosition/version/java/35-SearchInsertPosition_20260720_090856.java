// Last updated: 7/20/2026, 9:08:56 AM
1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        int left = 0;
4        int right = nums.length - 1;
5        
6        while (left <= right) {
7            int mid = left + (right - left) / 2;
8            
9            if (nums[mid] == target) {
10                return mid;
11            } else if (nums[mid] < target) {
12                left = mid + 1;
13            } else {
14                right = mid - 1;
15            }
16        }
17        
18        return left;
19    }
20}