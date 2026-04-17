class Solution {
    static boolean canFormPalindrome(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int oddCount = 0;

        for (int f : freq) {
            if (f % 2 != 0) {
                oddCount++;
                if (oddCount > 1) return false;
            }
        }

        return true;
    }
}