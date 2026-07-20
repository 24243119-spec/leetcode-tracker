// Last updated: 7/20/2026, 10:12:43 AM
class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow edge case: -2^31 / -1 = 2^31 (which overflows to 2^31 - 1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the quotient
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative to prevent overflow issues
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // Since both are negative, we loop as long as 'a' is less than or equal to 'b'
        // (e.g., -10 <= -3)
        while (a <= b) {
            int tempDivisor = b;
            int multiple = 1;

            // Shift left to find the highest multiple of divisor that fits
            // We check tempDivisor >= Integer.MIN_VALUE >> 1 to prevent overflow before shifting
            while (tempDivisor >= (Integer.MIN_VALUE >> 1) && a <= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest found multiple from the dividend
            a -= tempDivisor;
            // Add the multiple count to the quotient
            quotient += multiple;
        }

        // Return the correct signed integer
        return isNegative ? -quotient : quotient;
    }
}