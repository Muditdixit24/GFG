class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
        int totalsum=0;
        int currentsum=0;
        int maxsum=arr[0];
        int currentminsum=0;
        int minsum=arr[0];
        for(int i=0;i<arr.length;i++){
            currentsum= Math.max(arr[i],currentsum+arr[i]);
            maxsum=Math.max(maxsum,currentsum);
            currentminsum= Math.min(arr[i],
                      currentminsum+arr[i]);
            minsum=Math.min(minsum,currentminsum);
            totalsum= totalsum+arr[i];
        }
        if(maxsum<0){
            return maxsum;
        }
        return  Math.max(maxsum,totalsum-minsum);
    }
}
