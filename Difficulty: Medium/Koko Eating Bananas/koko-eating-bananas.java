class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int left = 1;
        int right = 0;

        // find max pile
        for (int p : arr) {
            right = Math.max(right, p);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(arr, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] arr, int k, int speed) {
        int hours = 0;

        for (int p : arr) {
            hours += (p + speed - 1) / speed; // ceiling division
        }

        return hours <= k;
    }
}
