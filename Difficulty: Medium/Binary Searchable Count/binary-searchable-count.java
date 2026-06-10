class Solution {

    private void solve(int[] arr, int l, int r, int mn, int mx, int[] ans) {
        if (l > r) {
            return;
        }

        int mid = (l + r) / 2;

        if (arr[mid] > mn && arr[mid] < mx) {
            ans[0]++;
        }

        solve(arr, l, mid - 1, mn, Math.min(mx, arr[mid]), ans);
        solve(arr, mid + 1, r, Math.max(mn, arr[mid]), mx, ans);
    }

    public int binarySearchable(int[] arr) {
        int[] ans = new int[1]; // acts as pass-by-reference
        solve(arr, 0, arr.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE, ans);
        return ans[0];
    }
}