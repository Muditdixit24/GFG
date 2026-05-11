class Solution {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public boolean palindromePair(String[] arr) {

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {

            String s = arr[i];

            for (int j = 0; j <= s.length(); j++) {

                String left = s.substring(0, j);
                String right = s.substring(j);

                // Case 1
                if (isPalindrome(left)) {

                    String rev = new StringBuilder(right).reverse().toString();

                    if (map.containsKey(rev) && map.get(rev) != i) {
                        return true;
                    }
                }

                // Case 2
                if (j != s.length() && isPalindrome(right)) {

                    String rev = new StringBuilder(left).reverse().toString();

                    if (map.containsKey(rev) && map.get(rev) != i) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}