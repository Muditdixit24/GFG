import java.util.*;

class Solution {
    public boolean isProduct(int[] arr, long target) {
        
        HashSet<Long> set = new HashSet<>();
        
        for (int num : arr) {
            
            // Special case for target = 0
            if (target == 0) {
                if (num == 0 && !set.isEmpty()) {
                    return true;
                }
                
                for (long x : set) {
                    if (x == 0 || num == 0) {
                        return true;
                    }
                }
            }
            
            else {
                if (num != 0 && target % num == 0) {
                    long needed = target / num;
                    
                    if (set.contains(needed)) {
                        return true;
                    }
                }
            }
            
            set.add((long) num);
        }
        
        return false;
    }
}