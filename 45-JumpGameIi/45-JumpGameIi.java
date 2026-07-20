// Last updated: 7/20/2026, 10:12:20 AM
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int maxReach = 0;

        // Loop up to nums.length - 1 because we don't need to jump from the last element
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            // If we've reached the end of the current jump boundary
            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;

                // Early exit if we can already reach or cross the end
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}