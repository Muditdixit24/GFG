class Solution {
    public long sumXOR(int[] arr) {
        long total = 0;
        int n = arr.length;
        
        // Check each bit position
        for (int bit = 0; bit < 32; bit++) {
            long countSet = 0;
            
            // Count how many numbers have this bit set
            for (int num : arr) {
                if ((num & (1 << bit)) != 0) {
                    countSet++;
                }
            }
            
            long countUnset = n - countSet;
            
            // Contribution of this bit
            total += countSet * countUnset * (1L << bit);
        }
        
        return total;
    }
}
