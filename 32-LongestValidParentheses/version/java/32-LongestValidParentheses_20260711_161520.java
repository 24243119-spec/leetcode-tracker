// Last updated: 7/11/2026, 4:15:20 PM
1class Solution {
2    public int longestValidParentheses(String s) {
3        Stack<Integer> stack = new Stack<>();
4        stack.push(-1); // Base index
5
6        int maxLength = 0;
7
8        for (int i = 0; i < s.length(); i++) {
9            if (s.charAt(i) == '(') {
10                stack.push(i);
11            } else {
12                stack.pop();
13
14                if (stack.isEmpty()) {
15                    stack.push(i);
16                } else {
17                    maxLength = Math.max(maxLength, i - stack.peek());
18                }
19            }
20        }
21
22        return maxLength;
23    }
24}