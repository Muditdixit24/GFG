import java.util.Arrays;

class Solution {
    public int findSmallest(int[] arr) {
        Arrays.sort(arr);

        int res = 1;

        for (int num : arr) {
            if (num > res) {
                return res;
            }

            res += num;
        }

        return res;
    }
}