class Solution {

   
    private int digitSum(long x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public int getCount(int n, int d) {

        long left = 1, right = n;
        long start = -1;

        
        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (mid - digitSum(mid) >= d) {
                start = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        
        if (start == -1) return 0;

        return (int)(n - start + 1);
    }
}
