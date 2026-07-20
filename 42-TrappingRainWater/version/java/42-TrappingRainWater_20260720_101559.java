// Last updated: 7/20/2026, 10:15:59 AM
1class Solution {
2    public double myPow(double x, int n) {
3        long N = n; // Use long to prevent integer overflow when n = Integer.MIN_VALUE (-2147483648)
4        if (N < 0) {
5            x = 1 / x;
6            N = -N;
7        }
8
9        double result = 1.0;
10        double currentProduct = x;
11
12        while (N > 0) {
13            // If N is odd, multiply the current power of x to the result
14            if ((N & 1) == 1) {
15                result *= currentProduct;
16            }
17            currentProduct *= currentProduct; // Square the base
18            N >>= 1; // Divide N by 2
19        }
20
21        return result;
22    }
23}