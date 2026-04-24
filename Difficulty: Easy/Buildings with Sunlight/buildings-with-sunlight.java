class Solution {
    public int visibleBuildings(int arr[]) {
        // code here
        int count =1;
        int max= arr[0];
        for(int i=1;i<arr.length;i++){
           
            if(arr[i]>=max){
                count++;
                max=arr[i];
            }
        }
        return count;
    }
}