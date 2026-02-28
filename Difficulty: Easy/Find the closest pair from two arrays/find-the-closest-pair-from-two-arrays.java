class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        
        int n = arr1.length;
        int m = arr2.length;
        
        int i = 0;
        int j = m - 1;
        
        int minDiff = Integer.MAX_VALUE;
        int num1 = 0, num2 = 0;
        
        while (i < n && j >= 0) {
            
            int sum = arr1[i] + arr2[j];
            int diff = Math.abs(sum - x);
            
           
            if (diff < minDiff) {
                minDiff = diff;
                num1 = arr1[i];
                num2 = arr2[j];
            }
            
            
            if (sum > x) {
                j--;
            } else {
                i++;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(num1);
        result.add(num2);
        
        return result;
    }
}