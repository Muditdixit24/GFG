class Solution {
    ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0, j = 0, k = 0;
        int n1 = a.length, n2 = b.length, n3 = c.length;

        while (i < n1 && j < n2 && k < n3) {
            
            // If all are equal → add to result
            if (a[i] == b[j] && b[j] == c[k]) {
                // Avoid duplicates in result
                if (res.size() == 0 || res.get(res.size() - 1) != a[i]) {
                    res.add(a[i]);
                }
                
                i++;
                j++;
                k++;
            }
            // Move pointer of smallest element
            else if (a[i] < b[j]) {
                i++;
            } else if (b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }
        
        return res;
    }
}