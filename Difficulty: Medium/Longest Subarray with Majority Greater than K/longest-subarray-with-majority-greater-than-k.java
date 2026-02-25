
class Solution {
    public int longestSubarray(int[] arr, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixSum = 0;
        int maxLength = 0;
        
        for (int i = 0; i < arr.length; i++) {
            
            // Convert values
            if (arr[i] > k) {
                prefixSum = prefixSum + 1;
            } else {
                prefixSum = prefixSum - 1;
            }
            
           
            if (prefixSum > 0) {
                maxLength = i + 1;
            }
            
            
            if (map.containsKey(prefixSum - 1)) {
                int length = i - map.get(prefixSum - 1);
                maxLength = Math.max(maxLength, length);
            }
            
          
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
}