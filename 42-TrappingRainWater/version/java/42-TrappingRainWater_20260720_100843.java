// Last updated: 7/20/2026, 10:08:43 AM
1class Solution {
2    public String multiply(String num1, String num2) {
3        if ("0".equals(num1) || "0".equals(num2)) {
4            return "0";
5        }
6        
7        int m = num1.length();
8        int n = num2.length();
9        int[] pos = new int[m + n];
10        
11        for (int i = m - 1; i >= 0; i--) {
12            for (int j = n - 1; j >= 0; j--) {
13                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
14                int p1 = i + j;
15                int p2 = i + j + 1;
16                
17                int sum = mul + pos[p2];
18                
19                pos[p1] += sum / 10;
20                pos[p2] = sum % 10;
21            }
22        }
23        
24        StringBuilder sb = new StringBuilder();
25        for (int p : pos) {
26            if (!(sb.length() == 0 && p == 0)) {
27                sb.append(p);
28            }
29        }
30        
31        return sb.length() == 0 ? "0" : sb.toString();
32    }
33}