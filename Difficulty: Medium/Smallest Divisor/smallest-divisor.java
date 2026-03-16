class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        int low=1;
        int high=0;
        for(int i=0;i<arr.length;i++){
            high=Math.max(high,arr[i]);
        }
        while(low<high){
            int mid= low+(high-low)/2;
            int sum=0;
            for(int i=0;i<arr.length;i++){
                sum=sum+(arr[i]+mid-1)/mid;
            }
            if(sum<=k){
                high= mid;
            }
            else{
                low= mid+1;
            }
        }
        return low;
    }
}