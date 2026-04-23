class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int left=0;
        for(int j=0;j<arr.length;j++){
            left+=arr[j];
            int right= sum-left;
            if(left==right) return true;
            
        }
        
        return false;
    }
}