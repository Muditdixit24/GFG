class Solution {
    int missingNum(int arr[]) {
        int n=arr.length+1;
        int sum=0;
        // code here
        for(int i=1;i<=n;i++){
            sum=sum+i;
        }
        int actual=0;
        for(int i=0;i<arr.length;i++){
            actual= actual+arr[i];
        }
        return sum-actual;
    }
}