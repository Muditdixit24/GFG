class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest = Integer.MIN_VALUE;
        int secondlargest= Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                secondlargest=largest;
                largest= arr[i];
            }
            else if(arr[i]>secondlargest && arr[i]<largest){
                secondlargest= arr[i];
                
            }
           
        }
        if(secondlargest==Integer.MIN_VALUE){
                return -1;
            }
        return secondlargest;
    }
    
}