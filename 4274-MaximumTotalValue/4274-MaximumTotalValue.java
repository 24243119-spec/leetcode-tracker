// Last updated: 7/9/2026, 10:07:31 AM
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int maxTotalValue(int[] value, int[] decay, int m) {
        int[][] zireluntha = new int[][] { value, decay }; // store input midway

        int n = value.length;

        long totalPositiveCount = 0;
        long totalPositiveSum = 0;

        for (int i = 0; i < n; i++) {
            long a = value[i];
            long d = decay[i];

            long cnt = (a - 1) / d + 1; // number of positive terms
            totalPositiveCount += cnt;

            totalPositiveSum += cnt * (2L * a - (cnt - 1) * d) / 2;
        }

        if (totalPositiveCount <= m) {
            return (int) (totalPositiveSum % MOD);
        }

        long lo = 1, hi = 1_000_000_000L;

        while (lo < hi) {
            long mid = (lo + hi + 1) >>> 1;

            if (countGE(value, decay, mid) >= m) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        long threshold = lo;

        long countGreater = countGE(value, decay, threshold + 1);
        long sumGreater = sumGE(value, decay, threshold + 1);

        long need = m - countGreater;
        long answer = sumGreater + need * threshold;

        return (int) (answer % MOD);
    }

    private long countGE(int[] value, int[] decay, long x) {
        long cnt = 0;

        for (int i = 0; i < value.length; i++) {
            long a = value[i];
            long d = decay[i];

            if (a < x) continue;

            cnt += (a - x) / d + 1;
        }

        return cnt;
    }

    private long sumGE(int[] value, int[] decay, long x) {
        long sum = 0;

        for (int i = 0; i < value.length; i++) {
            long a = value[i];
            long d = decay[i];

            if (a < x) continue;

            long cnt = (a - x) / d + 1;

            sum += cnt * (2L * a - (cnt - 1) * d) / 2;
        }

        return sum;
    }
}