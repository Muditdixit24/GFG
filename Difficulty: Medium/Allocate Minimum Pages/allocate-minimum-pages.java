class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        int n= arr.length;
        if(k>n) return -1;
        int low=0;
        int high=0;
        for(int i=0;i<n;i++){
            low= Math.max(low,arr[i]);
            high+=arr[i];
        }
        int ans=-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(ispossible(arr,n,k,mid)){
                ans= mid;
                high= mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean ispossible(int[]arr,int n, int k, int maxpages){
        int students=1;
        int pages=0;
        for(int i=0;i<n;i++){
            if(pages+arr[i]<=maxpages){
                pages=pages+arr[i];
            }
            else{
                students++;
                pages= arr[i];
            }
        }
        return students<=k;
    }
}