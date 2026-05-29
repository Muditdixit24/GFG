class Solution {
    int[][] dp;

    public int validGroups(String s) {
        int n = s.length();
        dp = new int[n + 1][901];

        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, s);
    }

    private int solve(int idx, int prevSum, String s) {
        int n = s.length();

        if (idx == n) {
            return 1;
        }

        if (dp[idx][prevSum] != -1) {
            return dp[idx][prevSum];
        }

        int count = 0;
        int currSum = 0;

        for (int i = idx; i < n; i++) {
            currSum += s.charAt(i) - '0';

            if (currSum >= prevSum) {
                count += solve(i + 1, currSum, s);
            }
        }

        return dp[idx][prevSum] = count;
    }
}