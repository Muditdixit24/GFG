class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        boolean[] present = new boolean[1001];
        
        for(int x : arr) {
            present[x] = true;
        }
        
        for(int a = 1; a <= 1000; a++) {
            if(!present[a]) continue;
            
            for(int b = a; b <= 1000; b++) {
                if(!present[b]) continue;
                
                int c2 = a*a + b*b;
                int c = (int)Math.sqrt(c2);
                
                if(c <= 1000 && c*c == c2 && present[c]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}