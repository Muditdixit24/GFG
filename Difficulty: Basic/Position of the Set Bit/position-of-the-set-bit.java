class Solution {
    public static int findPosition(int n) {
        // edge case: 0 has no set bits
        if (n == 0) return -1;

        // check if exactly one set bit
        if ((n & (n - 1)) != 0) return -1;

        int pos = 1;

        // find position of the set bit
        while ((n & 1) == 0) {
            n = n >> 1;
            pos++;
        }

        return pos;
    }
}