// Last updated: 7/20/2026, 10:13:15 AM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> permuteUnique(int[] nums) {
7        List<List<Integer>> result = new ArrayList<>();
8        Arrays.sort(nums); // Sort to group duplicates together
9        boolean[] used = new boolean[nums.length];
10        backtrack(nums, used, new ArrayList<>(), result);
11        return result;
12    }
13
14    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
15        if (current.size() == nums.length) {
16            result.add(new ArrayList<>(current));
17            return;
18        }
19
20        for (int i = 0; i < nums.length; i++) {
21            if (used[i]) {
22                continue;
23            }
24
25            // Skip duplicates: if the previous identical element was NOT used in this level, skip
26            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
27                continue;
28            }
29
30            used[i] = true;
31            current.add(nums[i]);
32
33            backtrack(nums, used, current, result);
34
35            // Backtrack
36            used[i] = false;
37            current.remove(current.size() - 1);
38        }
39    }
40}