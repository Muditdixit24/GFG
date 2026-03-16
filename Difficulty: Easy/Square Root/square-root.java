class Solution {
    int floorSqrt(int n) {
        // code here
        if(n==0 || n==1){
            return n;
        }
        int left = 1;
        int right =n;
        int ans = 0;
        while(left<=right){
            int mid = left + (right-left)/2;
            long square = (long) mid* mid;
            if(square == n){
                return mid;
            }
            else if(square<n){
                ans =mid;
                left = mid+1;

            }
            else {
                right = mid-1;
            }
        }
        return ans;
    }
}