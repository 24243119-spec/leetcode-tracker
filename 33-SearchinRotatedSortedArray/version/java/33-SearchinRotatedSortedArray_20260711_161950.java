// Last updated: 7/11/2026, 4:19:50 PM
1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3        int first = findFirst(nums, target);
4        int last = findLast(nums, target);
5
6        return new int[]{first, last};
7    }
8
9    private int findFirst(int[] nums, int target) {
10        int left = 0, right = nums.length - 1;
11        int ans = -1;
12
13        while (left <= right) {
14            int mid = left + (right - left) / 2;
15
16            if (nums[mid] == target) {
17                ans = mid;
18                right = mid - 1; // Continue searching on the left
19            } else if (nums[mid] < target) {
20                left = mid + 1;
21            } else {
22                right = mid - 1;
23            }
24        }
25
26        return ans;
27    }
28
29    private int findLast(int[] nums, int target) {
30        int left = 0, right = nums.length - 1;
31        int ans = -1;
32
33        while (left <= right) {
34            int mid = left + (right - left) / 2;
35
36            if (nums[mid] == target) {
37                ans = mid;
38                left = mid + 1; // Continue searching on the right
39            } else if (nums[mid] < target) {
40                left = mid + 1;
41            } else {
42                right = mid - 1;
43            }
44        }
45
46        return ans;
47    }
48}