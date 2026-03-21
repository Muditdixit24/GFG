import java.util.*;

class Solution {
    
    
    private int[] getCatalan(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp;
    }

    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        
        int[] cat = getCatalan(n);

        for (int i = 0; i < n; i++) {
            int root = arr[i];
            
            int left = 0, right = 0;
            
            
            for (int val : arr) {
                if (val < root) left++;
                else if (val > root) right++;
            }
            
            res.add(cat[left] * cat[right]);
        }
        
        return res;
    }
}