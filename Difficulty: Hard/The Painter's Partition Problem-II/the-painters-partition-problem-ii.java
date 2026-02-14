class Solution {
    
    public int minTime(int[] arr, int k) {
        int n = arr.length;
        
        int max = 0;
        long sum = 0;
        
        // Find max element and total sum
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        
        // If painters are more than boards
        if (k >= n) return max;
        
        long low = max;
        long high = sum;
        long ans = sum;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (isPossible(arr, k, mid)) {
                ans = mid;
                high = mid - 1;  // try smaller answer
            } else {
                low = mid + 1;   // need more time
            }
        }
        
        return (int) ans;
    }
    
    private boolean isPossible(int[] arr, int k, long maxTime) {
        int painters = 1;
        long currSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            
            if (currSum + arr[i] <= maxTime) {
                currSum += arr[i];
            } else {
                painters++;
                currSum = arr[i];
                
                if (painters > k) return false;
            }
        }
        
        return true;
    }
}
