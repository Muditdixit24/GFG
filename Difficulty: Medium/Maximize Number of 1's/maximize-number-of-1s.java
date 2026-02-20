class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int left=0;
        int right =0;
        int maxlength=0;
        int zeroscount=0;
        while(right<arr.length){
            if(arr[right]==0){
                zeroscount++;
            }
            while(zeroscount>k){
                if(arr[left]==0){
                    zeroscount--;
            }
            left++;
        }
        right++;
        maxlength= Math.max(maxlength,right-left);
        }
        return maxlength;
    }
}