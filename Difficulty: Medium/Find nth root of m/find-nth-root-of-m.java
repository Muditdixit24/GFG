class Solution {
    public int nthRoot(int n, int m) {
        // code here
        if(m == 0) return 0;
        int left = 1;
        int right =m;
        
        while(left<=right){
            int mid = left + (right-left)/2;
            long value = 1;
            for(int i=1;i<=n;i++){
                value=value*mid;
                 if(value > m) break;
            }
            if(value == m){
                return mid;
            }
            else if(value<m){
                
                left = mid+1;

            }
            else {
                right = mid-1;
            }
        }
        return -1;
    }
}