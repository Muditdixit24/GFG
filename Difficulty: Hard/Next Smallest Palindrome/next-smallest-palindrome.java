class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;

        // Step 1: Check if all 9s
        boolean all9 = true;
        for (int x : num) {
            if (x != 9) {
                all9 = false;
                break;
            }
        }

        if (all9) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        int[] arr = num.clone();

        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        // Step 2: Check if left < right
        boolean leftSmaller = false;

        while (i >= 0 && arr[i] == arr[j]) {
            i--;
            j++;
        }

        if (i < 0 || arr[i] < arr[j]) {
            leftSmaller = true;
        }

        // Step 3: Mirror left to right
        while (i >= 0) {
            arr[j] = arr[i];
            i--;
            j++;
        }

        // Step 4: If needed, add 1 to middle and propagate
        if (leftSmaller) {
            int carry = 1;

            i = mid - 1;

            if (n % 2 == 1) {
                arr[mid] += carry;
                carry = arr[mid] / 10;
                arr[mid] %= 10;
                j = mid + 1;
            } else {
                j = mid;
            }

            while (i >= 0 && carry > 0) {
                arr[i] += carry;
                carry = arr[i] / 10;
                arr[i] %= 10;
                arr[j] = arr[i]; // mirror
                i--;
                j++;
            }
        }

        return arr;
    }
}