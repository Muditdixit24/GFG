class Solution {
    public int totalElements(int[] arr) {
        // code here
        HashMap<Integer,Integer>map = new HashMap<>();

        int left=0;
        int right=0;
        int maxlength=0;
        while(right<arr.length){
            map.put(arr[right],
            map.getOrDefault(arr[right],0)+1);

            while(map.size()>2){
                map.put(arr[left],
                map.get(arr[left])-1);
                
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                left++;
            }
            
            maxlength=Math.max(maxlength,right-left+1);
            right++;
        }
        return maxlength;
    }
}