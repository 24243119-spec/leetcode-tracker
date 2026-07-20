// Last updated: 7/20/2026, 9:11:33 AM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<Integer>> combinationSum(int[] candidates, int target) {
6        List<List<Integer>> result = new ArrayList<>();
7        backtrack(candidates, target, 0, new ArrayList<>(), result);
8        return result;
9    }
10
11    private void backtrack(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
12        if (remaining == 0) {
13            result.add(new ArrayList<>(current));
14            return;
15        }
16
17        for (int i = start; i < candidates.length; i++) {
18            if (candidates[i] <= remaining) {
19                current.add(candidates[i]);
20                // Pass 'i' as start index because the same element can be reused
21                backtrack(candidates, remaining - candidates[i], i, current, result);
22                current.remove(current.size() - 1); // Backtrack
23            }
24        }
25    }
26}