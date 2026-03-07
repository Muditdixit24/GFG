class Solution {
    static int noOfWays(int m, int n, int x) {
        
        int[][] dp = new int[n + 1][x + 1];
        
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= x; sum++) {
                
                for (int face = 1; face <= m; face++) {
                    
                    if (sum - face >= 0)
                        dp[i][sum] += dp[i - 1][sum - face];
                }
            }
        }
        
        return dp[n][x];
    }
}