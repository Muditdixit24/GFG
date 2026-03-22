import java.util.*;

class Solution {

    public int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int n = stalls.length;

        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean canPlaceCows(int[] stalls, int cows, int dist) {
        int count = 1;
        int last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                count++;
                last = stalls[i];
            }

            if (count >= cows) return true;
        }

        return false;
    }
}