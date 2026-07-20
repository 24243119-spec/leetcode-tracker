// Last updated: 7/20/2026, 10:07:35 AM
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n = nums.length;
4        
5        // Place each number in its correct index (nums[i] should be i + 1)
6        for (int i = 0; i < n; i++) {
7            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
8                // Swap nums[i] with nums[nums[i] - 1]
9                int temp = nums[nums[i] - 1];
10                nums[nums[i] - 1] = nums[i];
11                nums[i] = temp;
12            }
13        }
14        
15        // Find the first index where nums[i] != i + 1
16        for (int i = 0; i < n; i++) {
17            if (nums[i] != i + 1) {
18                return i + 1;
19            }
20        }
21        
22        return n + 1;
23    }
24}