class Solution {
    int maxProduct(int[] arr) {
        int maxEnding = arr[0];
        int minEnding = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];

            int tempMax = Math.max(curr,
                    Math.max(curr * maxEnding, curr * minEnding));

            minEnding = Math.min(curr,
                    Math.min(curr * maxEnding, curr * minEnding));

            maxEnding = tempMax;

            result = Math.max(result, maxEnding);
        }

        return result;
    }
}
