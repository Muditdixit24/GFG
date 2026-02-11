class Solution {

    // helper to compute total cost for making all heights = target
    long computeCost(int[] heights, int[] cost, int target) {
        long total = 0;

        for (int i = 0; i < heights.length; i++) {
            total += (long)Math.abs(heights[i] - target) * cost[i];
        }

        return total;
    }

    public int minCost(int[] heights, int[] cost) {

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // find search range
        for (int h : heights) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }

        long ans = Long.MAX_VALUE;

        // binary search on height
        while (low <= high) {
            int mid = low + (high - low) / 2;

            long cost1 = computeCost(heights, cost, mid);
            long cost2 = computeCost(heights, cost, mid + 1);

            ans = Math.min(cost1, cost2);

            if (cost1 < cost2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int)ans; // GFG expects int
    }
}