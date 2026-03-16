class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int low=1;
        int high=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>high){
                high= arr[i];
            }
        }
        while(low<high){
            int mid= low +(high-low)/2;
            int hours=0;
            for(int i=0;i<arr.length;i++){
                hours= hours+(arr[i]+mid-1)/mid;
            }
            if(hours<=k){
                high= mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}
