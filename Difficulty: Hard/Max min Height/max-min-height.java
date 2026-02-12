class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;

        long low = Integer.MAX_VALUE;
        for (int x : arr) low = Math.min(low, x);

        long high = low + k;
        long ans = low;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (canAchieve(arr, n, k, w, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }

    private boolean canAchieve(int[] arr, int n, int k, int w, long target) {

        long[] diff = new long[n + 1];
        long added = 0;
        long used = 0;

        for (int i = 0; i < n; i++) {

            added += diff[i];
            long current = arr[i] + added;

            if (current < target) {

                long need = target - current;
                used += need;

                if (used > k) return false;

                added += need;

                if (i + w < diff.length)
                    diff[i + w] -= need;
            }
        }

        return true;
    }
}