class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        HashSet<Integer>set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        ArrayList<Integer>result= new ArrayList<>();
        for(int i=low;i<=high;i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}