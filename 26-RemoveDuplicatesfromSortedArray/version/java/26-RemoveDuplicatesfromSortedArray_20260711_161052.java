// Last updated: 7/11/2026, 4:10:52 PM
1class Solution {
2    public void nextPermutation(int[] nums) {
3        if (nums == null || nums.length <= 1) return;
4
5        // Step 1: Find the first decreasing element from the right
6        int i = nums.length - 2;
7        while (i >= 0 && nums[i] >= nums[i + 1]) {
8            i--;
9        }
10
11        // Step 2: If the pivot index is valid, find the successor and swap
12        if (i >= 0) {
13            int j = nums.length - 1;
14            while (nums[j] <= nums[i]) {
15                j--;
16            }
17            swap(nums, i, j);
18        }
19
20        // Step 3: Reverse the elements to the right of the pivot
21        reverse(nums, i + 1, nums.length - 1);
22    }
23
24    private void swap(int[] nums, int i, int j) {
25        int temp = nums[i];
26        nums[i] = nums[j];
27        nums[j] = temp;
28    }
29
30    private void reverse(int[] nums, int start, int end) {
31        while (start < end) {
32            swap(nums, start, end);
33            start++;
34            end--;
35        }
36    }
37}