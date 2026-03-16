class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        long need = (long)m * k;
        if(need > arr.length) return -1;
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for(int d : arr){
            left = Math.min(left, d);
            right = Math.max(right, d);
        }
        
        while(left < right){
            
            int mid = left + (right - left)/2;
            
            if(canMake(arr, m, k, mid))
                right = mid;
            else
                left = mid + 1;
        }
        
        return left;
    }
    
    boolean canMake(int[] arr, int m, int k, int day){
        
        int flowers = 0;
        int bouquets = 0;
        
        for(int d : arr){
            
            if(d <= day){
                flowers++;
                
                if(flowers == k){
                    bouquets++;
                    flowers = 0;
                }
            }
            else{
                flowers = 0;
            }
        }
        
        return bouquets >= m;
    }
}