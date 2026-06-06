class Solution {
    public int numOfWays(int n, int m) {
        long total = (long) n * m * (n * m - 1); // total ordered pairs
        long attacking = 4L * (n - 1) * (m - 2) + 4L * (n - 2) * (m - 1);
        return (int) (total - attacking);
    }
}
