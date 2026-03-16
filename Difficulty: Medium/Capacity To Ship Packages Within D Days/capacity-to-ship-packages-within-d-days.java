// User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        // code here
        int low=0;
        int high=0;
        for(int i=0;i<arr.length;i++){
            low= Math.max(low,arr[i]);
            high=high+arr[i];
        }
        while(low<high){
            int mid= (low+high)/2;
            int req=1;
            int currweight=0;
            for(int i=0;i<arr.length;i++){
                if(currweight+arr[i]>mid){
                    req++;
                    currweight=0;
                }
                currweight+=arr[i];
            }
            if(req<=d){
                high= mid;
            }
            else{
                low= mid+1;
            }
        }
        return low;
    }
};