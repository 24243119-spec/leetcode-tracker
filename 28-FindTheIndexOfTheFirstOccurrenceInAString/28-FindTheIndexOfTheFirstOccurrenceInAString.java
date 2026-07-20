// Last updated: 7/20/2026, 10:12:44 AM
class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: if needle is longer than haystack, it can't be a substring
        if (haystack.length() < needle.length()) {
            return -1;
        }
        
        int hLen = haystack.length();
        int nLen = needle.length();
        
        // Loop through the haystack up to the point where needle can fit
        for (int i = 0; i <= hLen - nLen; i++) {
            // Check if the substring matches the needle
            if (haystack.substring(i, i + nLen).equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}