// Last updated: 7/20/2026, 9:13:28 AM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
7        List<List<Integer>> result = new ArrayList<>();
8        Arrays.sort(candidates); // Sort to group duplicates
9        backtrack(candidates, target, 0, new ArrayList<>(), result);
10        return result;
11    }
12
13    private void backtrack(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
14        if (remaining == 0) {
15            result.add(new ArrayList<>(current));
16            return;
17        }
18
19        for (int i = start; i < candidates.length; i++) {
20            // Stop early if candidate exceeds remaining sum
21            if (candidates[i] > remaining) {
22                break;
23            }
24
25            // Skip duplicates at the same recursion depth
26            if (i > start && candidates[i] == candidates[i - 1]) {
27                continue;
28            }
29
30            current.add(candidates[i]);
31            // Move to i + 1 as each number can only be used once
32            backtrack(candidates, remaining - candidates[i], i + 1, current, result);
33            current.remove(current.size() - 1);
34        }
35    }
36}