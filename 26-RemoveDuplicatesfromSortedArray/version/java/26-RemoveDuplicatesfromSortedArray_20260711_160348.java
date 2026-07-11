// Last updated: 7/11/2026, 4:03:48 PM
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        if (nums == null || nums.length == 0) {
4            return 0;
5        }
6        
7        int i = 0;
8        
9        for (int j = 1; j < nums.length; j++) {
10            if (nums[j] != nums[i]) {
11                i++; 
12                nums[i] = nums[j]; 
13            }
14        }
15        
16        return i + 1;
17    }
18}