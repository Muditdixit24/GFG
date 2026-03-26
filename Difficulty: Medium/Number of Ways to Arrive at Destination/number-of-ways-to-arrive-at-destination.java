class Solution {
    public int countPaths(int V, int[][] edges) {
        int mod = (int)1e9 + 7;
        
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        int[] ways = new int[V];
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );
        
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0}); 
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];
            
            if (d > dist[node]) continue;
            
            for (int[] nei : adj.get(node)) {
                int v = nei[0];
                int wt = nei[1];
                
                if (d + wt < dist[v]) {
                    dist[v] = d + wt;
                    ways[v] = ways[node];
                    pq.offer(new long[]{dist[v], v});
                } 
                else if (d + wt == dist[v]) {
                    ways[v] = (ways[v] + ways[node]) % mod;
                }
            }
        }
        
        return ways[V - 1];
    }
}