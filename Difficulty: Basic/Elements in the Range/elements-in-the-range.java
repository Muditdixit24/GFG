class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        
        boolean[] present = new boolean[end + 1];
        
        // Mark elements present in array
        for (int num : arr) {
            if (num >= start && num <= end) {
                present[num] = true;
            }
        }
        
        // Check all elements in range
        for (int i = start; i <= end; i++) {
            if (!present[i]) {
                return false;
            }
        }
        
        return true;
    }
}