// Last updated: 7/11/2026, 4:05:15 PM
1class Solution {
2    public int removeElement(int[] nums, int val) {
3        if (nums == null || nums.length == 0) {
4            return 0;
5        }
6        
7        int writePointer = 0;
8        
9        // Loop through all elements using the read pointer
10        for (int readPointer = 0; readPointer < nums.length; readPointer++) {
11            // If the current element is not the value to remove
12            if (nums[readPointer] != val) {
13                nums[writePointer] = nums[readPointer];
14                writePointer++; // Move the write pointer forward
15            }
16        }
17        
18        // writePointer now holds the count of elements not equal to val
19        return writePointer;
20    }
21}