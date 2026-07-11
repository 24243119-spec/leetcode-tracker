// Last updated: 7/11/2026, 4:06:27 PM
1class Solution {
2    public int divide(int dividend, int divisor) {
3        // Handle overflow edge case: -2^31 / -1 = 2^31 (which overflows to 2^31 - 1)
4        if (dividend == Integer.MIN_VALUE && divisor == -1) {
5            return Integer.MAX_VALUE;
6        }
7
8        // Determine the sign of the quotient
9        boolean isNegative = (dividend < 0) ^ (divisor < 0);
10
11        // Convert both numbers to negative to prevent overflow issues
12        int a = dividend < 0 ? dividend : -dividend;
13        int b = divisor < 0 ? divisor : -divisor;
14
15        int quotient = 0;
16
17        // Since both are negative, we loop as long as 'a' is less than or equal to 'b'
18        // (e.g., -10 <= -3)
19        while (a <= b) {
20            int tempDivisor = b;
21            int multiple = 1;
22
23            // Shift left to find the highest multiple of divisor that fits
24            // We check tempDivisor >= Integer.MIN_VALUE >> 1 to prevent overflow before shifting
25            while (tempDivisor >= (Integer.MIN_VALUE >> 1) && a <= (tempDivisor << 1)) {
26                tempDivisor <<= 1;
27                multiple <<= 1;
28            }
29
30            // Subtract the largest found multiple from the dividend
31            a -= tempDivisor;
32            // Add the multiple count to the quotient
33            quotient += multiple;
34        }
35
36        // Return the correct signed integer
37        return isNegative ? -quotient : quotient;
38    }
39}