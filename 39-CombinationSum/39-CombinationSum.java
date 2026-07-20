// Last updated: 7/20/2026, 10:12:29 AM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= remaining) {
                current.add(candidates[i]);
                // Pass 'i' as start index because the same element can be reused
                backtrack(candidates, remaining - candidates[i], i, current, result);
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }
}