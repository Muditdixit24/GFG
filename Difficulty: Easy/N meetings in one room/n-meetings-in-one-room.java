

class Solution {
    
    // Function to find the maximum number of meetings
    public int maxMeetings(int start[], int end[]) {
        
        int n = start.length;
        
        // Step 1: Store meetings in ArrayList
        ArrayList<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(new int[]{start[i], end[i]});
        }
        
        // Step 2: Sort by ending time
        Collections.sort(list, (a, b) -> a[1] - b[1]);
        
        // Step 3: Select first meeting
        int count = 1;
        int lastEnd = list.get(0)[1];
        
        // Step 4: Select remaining meetings
        for (int i = 1; i < n; i++) {
            if (list.get(i)[0] > lastEnd) {
                count++;
                lastEnd = list.get(i)[1];
            }
        }
        
        return count;
    }
}
