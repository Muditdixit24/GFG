class Solution {
    public static String minWindow(String s, String p) {
        
        if (p.length() > s.length()) return "";
        
        int[] freq = new int[256];
        
        for (char c : p.toCharArray()) {
            freq[c]++;
        }
        
        int left = 0, right = 0;
        int count = p.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        while (right < s.length()) {
            
            if (freq[s.charAt(right)] > 0) {
                count--;
            }
            
            freq[s.charAt(right)]--;
            right++;
            
            while (count == 0) {
                
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                
                freq[s.charAt(left)]++;
                
                if (freq[s.charAt(left)] > 0) {
                    count++;
                }
                
                left++;
            }
        }
        
        if (minLen == Integer.MAX_VALUE) return "";
        
        return s.substring(start, start + minLen);
    }
}