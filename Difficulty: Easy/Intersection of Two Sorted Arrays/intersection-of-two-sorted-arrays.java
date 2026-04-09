class Solution {
    public ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (i < a.length && j < b.length) {
            
            if (a[i] < b[j]) {
                i++;
            } 
            else if (a[i] > b[j]) {
                j++;
            } 
            else {
                // Avoid duplicates in result
                if (ans.isEmpty() || ans.get(ans.size() - 1) != a[i]) {
                    ans.add(a[i]);
                }
                i++;
                j++;
            }
        }
        
        return ans;
    }
}