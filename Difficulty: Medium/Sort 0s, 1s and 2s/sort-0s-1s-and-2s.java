class Solution {
    public void sort012(int[] arr) {
        // code here
        int count=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count++;
            }
            else if(arr[i]==1){
                count1++;
            }
            else{
                count2++;
            }
        }
        int index=0;
        for(int i=0;i<count;i++){
            arr[index]=0;
            index++;
        }
        for(int i=0;i<count1;i++){
            arr[index]=1;
            index++;
        }
        for(int i=0;i<count2;i++){
            arr[index]=2;
            index++;
        }
    }
}