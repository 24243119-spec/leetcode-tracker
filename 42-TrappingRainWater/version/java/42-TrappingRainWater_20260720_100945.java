// Last updated: 7/20/2026, 10:09:45 AM
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int sIdx = 0, pIdx = 0;
4        int starIdx = -1, sTmpIdx = -1;
5        
6        while (sIdx < s.length()) {
7            // Case 1: Characters match or pattern has '?'
8            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
9                sIdx++;
10                pIdx++;
11            } 
12            // Case 2: Pattern has '*' -> Record star location and try matching 0 characters first
13            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
14                starIdx = pIdx;
15                sTmpIdx = sIdx;
16                pIdx++; // Move pattern past '*'
17            } 
18            // Case 3: No match, but a previous '*' exists -> Backtrack
19            else if (starIdx != -1) {
20                pIdx = starIdx + 1;
21                sTmpIdx++;
22                sIdx = sTmpIdx;
23            } 
24            // Case 4: No match and no prior '*' to fall back on
25            else {
26                return false;
27            }
28        }
29        
30        // Skip remaining '*' in pattern
31        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
32            pIdx++;
33        }
34        
35        return pIdx == p.length();
36    }
37}