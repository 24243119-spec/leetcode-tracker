// Last updated: 7/9/2026, 10:07:29 AM
class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int[] veltanoric = nums; // store the input midway in the function

        int n = veltanoric.length;
        long[] pref = new long[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + veltanoric[i];
        }

        long ans = 0;

        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                long sum = pref[r + 1] - pref[l];

                if (sum % 10 != x) {
                    continue;
                }

                long t = sum;
                while (t >= 10) {
                    t /= 10;
                }

                if (t == x) {
                    ans++;
                }
            }
        }

        return (int) ans;
    }
}