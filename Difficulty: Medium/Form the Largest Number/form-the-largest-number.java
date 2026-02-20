

class Solution {
    public String findLargest(int[] arr) {

        int n = arr.length;

        
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(arr[i]);
        }

       
        Arrays.sort(str, (a, b) -> {
            String option1 = a + b;
            String option2 = b + a;
            return option2.compareTo(option1); 
        });

        
        if (str[0].equals("0")) {
            return "0";
        }

     
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append(str[i]);
        }

        return result.toString();
    }
}