class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;

        // Step 1: count total 1s
        int totalOnes = 0;
        for (int x : arr) {
            if (x == 1) totalOnes++;
        }

        // Edge case
        if (totalOnes == 0) return -1;

        // Step 2: sliding window
        int currOnes = 0;

        // first window
        for (int i = 0; i < totalOnes; i++) {
            if (arr[i] == 1) currOnes++;
        }

        int maxOnes = currOnes;

        // slide window
        for (int i = totalOnes; i < n; i++) {
            if (arr[i] == 1) currOnes++;              // add new
            if (arr[i - totalOnes] == 1) currOnes--;  // remove old

            maxOnes = Math.max(maxOnes, currOnes);
        }

        return totalOnes - maxOnes;
    }
}