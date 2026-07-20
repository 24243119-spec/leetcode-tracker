// Last updated: 7/20/2026, 10:12:41 AM
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCountTotal = words.length;
        int totalLen = wordLen * wordCountTotal;
        int sLen = s.length();

        // Frequency map for the expected words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.merge(word, 1, Integer::sum));
        }

        // We only need to scan wordLen times because any other start position 
        // will be covered by one of these shifts.
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> currentCount = new HashMap<>();
            int wordsUsed = 0;

            // Slide the window rightward by wordLen steps
            while (right + wordLen <= sLen) {
                // Get the next word from the right side of the window
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    wordsUsed++;

                    // If we have more instances of 'word' than expected,
                    // slide the left pointer to shrink the window until it's valid again.
                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        left += wordLen;
                        wordsUsed--;
                    }

                    // If the window matches the exact total words required
                    if (wordsUsed == wordCountTotal) {
                        result.add(left);
                    }
                } else {
                    // Encountered an invalid word: reset the window entirely
                    currentCount.clear();
                    wordsUsed = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}