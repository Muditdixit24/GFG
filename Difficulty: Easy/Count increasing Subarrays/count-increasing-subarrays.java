class Solution {
    public int countIncreasing(int[] arr) {
        // code here
        int n = arr.length;
        int len = 1;   // current increasing length
        int ans = 0;
        
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
                ans += (len - 1); // new subarrays formed
            } else {
                len = 1;
            }
        }
        
        return ans;
    }
}
