class Solution {
    int maxOnes(int[] arr) {
        int totalOnes = 0;

        // Count existing 1s
        for (int x : arr) {
            if (x == 1) totalOnes++;
        }

        // Kadane's Algorithm on transformed values
        int maxGain = 0;
        int currGain = 0;

        for (int x : arr) {
            int val = (x == 0) ? 1 : -1;

            currGain = Math.max(val, currGain + val);
            maxGain = Math.max(maxGain, currGain);
        }

        return totalOnes + maxGain;
    }
}