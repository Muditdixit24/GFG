class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        // code here
        ArrayList<Integer>list=new ArrayList<>();
        PriorityQueue<Integer>minheap=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            minheap.add(arr[i]);
            if(minheap.size()>k){
                minheap.poll();
            }
            if(minheap.size()<k){
                list.add(-1);
            }
            else{
                list.add(minheap.peek());
            }
        }
        return list;
    }
}