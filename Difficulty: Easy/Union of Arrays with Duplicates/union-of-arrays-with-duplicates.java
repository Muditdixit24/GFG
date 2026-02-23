class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        
       
        HashSet<Integer> set = new HashSet<>();
        
       
        for(int i = 0; i < a.length; i++) {
            int element = a[i];
            set.add(element);
        }
        
        
        for(int i = 0; i < b.length; i++) {
            int element = b[i];
            set.add(element);
        }
        
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int element : set) {
            result.add(element);
        }
        
        return result;
    }
}