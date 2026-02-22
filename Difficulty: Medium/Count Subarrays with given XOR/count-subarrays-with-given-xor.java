

class Solution {
    public long subarrayXor(int arr[], int k) {
        
       
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixXOR = 0;
        int count = 0;
        
        
        map.put(0, 1);
        
        for (int i = 0; i < arr.length; i++) {
            
            
            prefixXOR = prefixXOR ^ arr[i];
            
            
            int required = prefixXOR ^ k;
            
            if (map.containsKey(required)) {
                count += map.get(required);
            }
            
   
            map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1);
        }
        
        return count;
    }
}