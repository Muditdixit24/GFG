import java.util.*;

class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        
        int n = a1.length;
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixSum = 0;
        int maxLength = 0;
        
        
        map.put(0, -1);
        
        for (int i = 0; i < n; i++) {
            
           
            int diff = a1[i] - a2[i];
            
            prefixSum = prefixSum + diff;
            
            
            if (map.containsKey(prefixSum)) {
                
                int firstIndex = map.get(prefixSum);
                int length = i - firstIndex;
                
                if (length > maxLength) {
                    maxLength = length;
                }
                
            } else {
                
                map.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
}