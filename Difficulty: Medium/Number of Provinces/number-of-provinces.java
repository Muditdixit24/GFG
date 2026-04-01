// User function Template for Java

import java.util.*;

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(i, adj, visited, V);
                count++;
            }
        }

        return count;
    }

    private static void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int V) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int j = 0; j < V; j++) {
                if (adj.get(node).get(j) == 1 && !visited[j]) {
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
    }
}