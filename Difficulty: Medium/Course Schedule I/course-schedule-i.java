class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            
            adj.get(prereq).add(course); 
            indegree[course]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        
        return count == n;
    }
}