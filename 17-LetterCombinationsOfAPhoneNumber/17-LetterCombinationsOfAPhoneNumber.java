// Last updated: 7/9/2026, 10:07:56 AM
import java.util.*;

class Solution {

    private List<String> result = new ArrayList<>();

    private final String[] mapping = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder());

        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current) {

        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {

            current.append(c);

            backtrack(digits, index + 1, current);

            current.deleteCharAt(current.length() - 1);
        }
    }
}