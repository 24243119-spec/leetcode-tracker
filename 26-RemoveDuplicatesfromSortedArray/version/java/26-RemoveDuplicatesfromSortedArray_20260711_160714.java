// Last updated: 7/11/2026, 4:07:14 PM
1import java.util.ArrayList;
2import java.util.HashMap;
3import java.util.List;
4import java.util.Map;
5
6class Solution {
7    public List<Integer> findSubstring(String s, String[] words) {
8        List<Integer> result = new ArrayList<>();
9        if (s == null || s.length() == 0 || words == null || words.length == 0) {
10            return result;
11        }
12
13        int wordLen = words[0].length();
14        int wordCountTotal = words.length;
15        int totalLen = wordLen * wordCountTotal;
16        int sLen = s.length();
17
18        // Frequency map for the expected words
19        Map<String, Integer> wordCount = new HashMap<>();
20        for (String word : words) {
21            wordCount.put(word, wordCount.merge(word, 1, Integer::sum));
22        }
23
24        // We only need to scan wordLen times because any other start position 
25        // will be covered by one of these shifts.
26        for (int i = 0; i < wordLen; i++) {
27            int left = i;
28            int right = i;
29            Map<String, Integer> currentCount = new HashMap<>();
30            int wordsUsed = 0;
31
32            // Slide the window rightward by wordLen steps
33            while (right + wordLen <= sLen) {
34                // Get the next word from the right side of the window
35                String word = s.substring(right, right + wordLen);
36                right += wordLen;
37
38                if (wordCount.containsKey(word)) {
39                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
40                    wordsUsed++;
41
42                    // If we have more instances of 'word' than expected,
43                    // slide the left pointer to shrink the window until it's valid again.
44                    while (currentCount.get(word) > wordCount.get(word)) {
45                        String leftWord = s.substring(left, left + wordLen);
46                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
47                        left += wordLen;
48                        wordsUsed--;
49                    }
50
51                    // If the window matches the exact total words required
52                    if (wordsUsed == wordCountTotal) {
53                        result.add(left);
54                    }
55                } else {
56                    // Encountered an invalid word: reset the window entirely
57                    currentCount.clear();
58                    wordsUsed = 0;
59                    left = right;
60                }
61            }
62        }
63
64        return result;
65    }
66}