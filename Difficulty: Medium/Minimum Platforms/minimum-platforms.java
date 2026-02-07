class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int n=arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1;
        int j=0;
        int count=1;
        int max=1;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
             max= Math.max(max,count);
        }
       
        return max;
    }
}
