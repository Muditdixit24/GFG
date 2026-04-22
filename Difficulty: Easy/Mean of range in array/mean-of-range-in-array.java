class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // code here
        ArrayList<Integer>ans= new ArrayList<>();
        int n= arr.length;
        int[]prefix=new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            int sum;
            if(l==0){
                sum=prefix[r];
            }
            else{
                sum=prefix[r]-prefix[l-1];
            }
            int length=r-l+1;
             int mean= sum/length;
             ans.add(mean);
        }
        return ans;
        
    }
}