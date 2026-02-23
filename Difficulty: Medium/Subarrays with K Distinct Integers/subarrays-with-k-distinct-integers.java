// User function Template for Java

class Solution {
    static int exactlyK(int arr[], int k) {
        // code here
         return countAtMost(arr,k)-countAtMost(arr,k-1);
    }
    private static int countAtMost(int[]arr,int k){
        if(k<0)
        return 0;
        int left=0;
        int right=0;
        int count=0;
        int n=arr.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        while(right<n){
           map.put(arr[right],
           map.getOrDefault(arr[right],0)+1);
           while(map.size()>k){
            map.put(arr[left],map.get(arr[left])-1);
            if(map.get(arr[left])==0){
                map.remove(arr[left]);
            }
            left++;
           }
           count=count+(right-left+1);
           right++;
        }
        return count;
    }
}
