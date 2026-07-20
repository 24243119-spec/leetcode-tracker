// Last updated: 7/20/2026, 10:12:45 AM
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int writePointer = 0;
        
        // Loop through all elements using the read pointer
        for (int readPointer = 0; readPointer < nums.length; readPointer++) {
            // If the current element is not the value to remove
            if (nums[readPointer] != val) {
                nums[writePointer] = nums[readPointer];
                writePointer++; // Move the write pointer forward
            }
        }
        
        // writePointer now holds the count of elements not equal to val
        return writePointer;
    }
}