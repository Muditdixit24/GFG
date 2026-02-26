class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        
       
        char[] map1 = new char[26];
        
        
        char[] map2 = new char[26];
        
      
        for (int i = 0; i < s1.length(); i++) {
            
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            int index1 = c1 - 'a';
            int index2 = c2 - 'a';
            
            
            if (map1[index1] != 0) {
                if (map1[index1] != c2) {
                    return false;
                }
            } 
            else {
                map1[index1] = c2;
            }
            
        
            if (map2[index2] != 0) {
                if (map2[index2] != c1) {
                    return false;
                }
            } 
            else {
                map2[index2] = c1;
            }
        }
        
        return true;
    }
}