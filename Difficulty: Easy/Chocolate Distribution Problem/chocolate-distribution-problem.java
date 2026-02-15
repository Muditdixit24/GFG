import java.util.*;

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        
        int n = arr.size();
        
        // Edge case
        if (m == 0 || n == 0) {
            return 0;
        }
        
        // Step 1: Sort the array
        Collections.sort(arr);
        
        // Step 2: Initialize answer
        int minDiff = Integer.MAX_VALUE;
        
        // Step 3: Sliding window of size m
        for (int i = 0; i <= n - m; i++) {
            
            int currentDiff = arr.get(i + m - 1) - arr.get(i);
            
            minDiff = Math.min(minDiff, currentDiff);
        }
        
        // Step 4: Return result
        return minDiff;
    }
}
