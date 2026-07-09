// Last updated: 7/9/2026, 10:07:27 AM
class Solution {
    public int maxDistance(String moves) {
        int x = 0, y = 0, wild = 0;

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U': y++; break;
                case 'D': y--; break;
                case 'R': x++; break;
                case 'L': x--; break;
                case '_': wild++; break;
            }
        }

        return Math.abs(x) + Math.abs(y) + wild;
    }
}