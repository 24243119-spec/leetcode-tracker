// Last updated: 7/20/2026, 10:12:22 AM
class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;
        
        while (sIdx < s.length()) {
            // Case 1: Characters match or pattern has '?'
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                sIdx++;
                pIdx++;
            } 
            // Case 2: Pattern has '*' -> Record star location and try matching 0 characters first
            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                sTmpIdx = sIdx;
                pIdx++; // Move pattern past '*'
            } 
            // Case 3: No match, but a previous '*' exists -> Backtrack
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                sTmpIdx++;
                sIdx = sTmpIdx;
            } 
            // Case 4: No match and no prior '*' to fall back on
            else {
                return false;
            }
        }
        
        // Skip remaining '*' in pattern
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        
        return pIdx == p.length();
    }
}