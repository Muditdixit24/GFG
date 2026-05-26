class Solution {
    public int minToggle(int[] arr) {
        int n = arr.length;

        // prefixOnes[i] = number of 1s from 0 to i-1
        int[] prefixOnes = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixOnes[i + 1] = prefixOnes[i] + (arr[i] == 1 ? 1 : 0);
        }

        int totalOnes = prefixOnes[n];
        int ans = Integer.MAX_VALUE;

        // partition at index i
        // left side -> all 0s
        // right side -> all 1s
        for (int i = 0; i <= n; i++) {
            int leftOnes = prefixOnes[i]; // 1s to convert into 0s
            int rightZeros = (n - i) - (totalOnes - prefixOnes[i]);

            ans = Math.min(ans, leftOnes + rightZeros);
        }

        return ans;
    }
}