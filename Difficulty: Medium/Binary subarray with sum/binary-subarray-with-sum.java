// User function Template for Java

class Solution {
    public int numberOfSubarrays(int[] arr, int target) {
        // code here
        return countAtMost(arr,target)-
        countAtMost(arr,target-1);
    }
    private int countAtMost(int[]arr,int target){
        if(target<0)
        return 0;
        int left=0;
        int right=0;
        int sum=0;
        int count=0;
        int n= arr.length;
        while(right<n){
            sum= sum+arr[right];
            while(sum>target){
                sum= sum-arr[left];
                left++;
            }
            count= count+(right-left+1);
            right++;
        }
        return count;
    }
}