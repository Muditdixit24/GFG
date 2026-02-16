import java.util.Arrays;

class Solution {
    public boolean canAttend(int[][] arr) {
        
        // Step 1: Sort meetings based on start time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        // Step 2: Check for overlap
        for (int i = 1; i < arr.length; i++) {
            
            int prevEnd = arr[i - 1][1];
            int currStart = arr[i][0];
            
            // If current meeting starts before previous ends → overlap
            if (currStart < prevEnd) {
                return false;
            }
        }
        
        // Step 3: No overlap found
        return true;
    }
}
