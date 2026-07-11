// Last updated: 7/11/2026, 4:02:47 PM
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums == null || nums.length == 0) {
4            return 0;
5        }
6        
7        // Pointer for the position of the last unique element found
8        int i = 0;
9        
10        // Iterate through the array starting from the second element
11        for (int j = 1; j < nums.length; j++) {
12            // If we find a new unique element
13            if (nums[j] != nums[i]) {
14                i++; // Move to the next slot
15                nums[i] = nums[j]; // Update the slot with the unique element
16            }
17        }
18        
19        // The number of unique elements is the index + 1
20        return i + 1;
21    }
22}