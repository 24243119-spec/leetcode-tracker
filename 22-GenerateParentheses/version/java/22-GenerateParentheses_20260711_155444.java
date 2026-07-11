// Last updated: 7/11/2026, 3:54:44 PM
1class Solution {
2    public List<String> generateParenthesis(int n) {
3        List<String> result = new ArrayList<>();
4        backtrack(result, new StringBuilder(), 0, 0, n);
5        return result;
6    }
7    
8    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
9        if (current.length() == max * 2) {
10            result.add(current.toString());
11            return;
12        }
13        
14        if (open < max) {
15            current.append("(");
16            backtrack(result, current, open + 1, close, max);
17            current.deleteCharAt(current.length() - 1); 
18        }
19        
20       
21        if (close < open) {
22            current.append(")");
23            backtrack(result, current, open, close + 1, max);
24            current.deleteCharAt(current.length() - 1); 
25        }
26    }
27}