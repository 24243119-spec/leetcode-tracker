// Last updated: 7/11/2026, 4:05:52 PM
1class Solution {
2    public int strStr(String haystack, String needle) {
3        // Edge case: if needle is longer than haystack, it can't be a substring
4        if (haystack.length() < needle.length()) {
5            return -1;
6        }
7        
8        int hLen = haystack.length();
9        int nLen = needle.length();
10        
11        // Loop through the haystack up to the point where needle can fit
12        for (int i = 0; i <= hLen - nLen; i++) {
13            // Check if the substring matches the needle
14            if (haystack.substring(i, i + nLen).equals(needle)) {
15                return i;
16            }
17        }
18        
19        return -1;
20    }
21}