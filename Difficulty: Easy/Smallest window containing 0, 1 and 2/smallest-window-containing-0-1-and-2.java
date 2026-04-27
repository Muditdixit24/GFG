class Solution {
    public int smallestSubstring(String s) {
        int n = s.length();
        
        int c0 = 0, c1 = 0, c2 = 0; // count of 0,1,2
        int left = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            // add current character
            char ch = s.charAt(right);
            if (ch == '0') c0++;
            else if (ch == '1') c1++;
            else if (ch == '2') c2++;

            // if window has all 3 characters
            while (c0 > 0 && c1 > 0 && c2 > 0) {

                // update answer
                ans = Math.min(ans, right - left + 1);

                // remove left character
                char leftChar = s.charAt(left);
                if (leftChar == '0') c0--;
                else if (leftChar == '1') c1--;
                else if (leftChar == '2') c2--;

                left++; // shrink window
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}