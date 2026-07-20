// Last updated: 7/20/2026, 9:10:30 AM
1class Solution {
2    public String countAndSay(int n) {
3        String result = "1";
4        
5        for (int i = 1; i < n; i++) {
6            StringBuilder current = new StringBuilder();
7            int count = 1;
8            
9            for (int j = 0; j < result.length(); j++) {
10                // If next character is the same, increment count
11                if (j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
12                    count++;
13                } else {
14                    // Append frequency followed by the digit
15                    current.append(count).append(result.charAt(j));
16                    count = 1; // Reset count for next digit group
17                }
18            }
19            result = current.toString();
20        }
21        
22        return result;
23    }
24}