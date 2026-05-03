import java.util.*;

class Solution {
    static ArrayList<Integer> sortBySetBitCount(int[] arr) {
        
        Integer[] temp = new Integer[arr.length];
        
        // Convert int[] → Integer[]
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        // Sort by set bits (descending)
        Arrays.sort(temp, (a, b) -> Integer.bitCount(b) - Integer.bitCount(a));

        // Convert to ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : temp) {
            result.add(num);
        }

        return result;
    }
}