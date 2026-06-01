class Solution {
    public int findMaxProduct(int[] arr) {
        long mod = 1000000007;
        int n = arr.length;
        
        if (n == 1) return arr[0] % (int)mod;

        long product = 1;
        int countNeg = 0, countZero = 0;
        int maxNeg = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num == 0) {
                countZero++;
                continue;
            }
            if (num < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, num);
            }
            product = (product * num) % mod;
        }

        // Case: all zeros
        if (countZero == n) return 0;

        // Case: odd negatives and no positives
        if (countNeg % 2 == 1) {
            if (countNeg == 1 && countZero > 0 && countZero + countNeg == n) {
                return 0; // only one negative and rest zeros
            }
            product = product / maxNeg; // remove smallest negative
        }

        return (int)((product + mod) % mod);
    }
}
