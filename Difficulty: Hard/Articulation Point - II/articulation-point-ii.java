import java.util.*;

class Solution {
    public ArrayList<Integer> articulationPoints(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] isAP = new boolean[V];
        int[] parent = new int[V];
        int[] childCount = new int[V];

        Arrays.fill(parent, -1);

        int timer = 0;

        for (int start = 0; start < V; start++) {
            if (visited[start]) continue;

            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{start, 0}); // node, next neighbor index

            while (!stack.isEmpty()) {
                int[] top = stack.peek();
                int node = top[0];
                int idx = top[1];

                if (!visited[node]) {
                    visited[node] = true;
                    tin[node] = low[node] = timer++;
                }

                if (idx < adj.get(node).size()) {
                    int nei = adj.get(node).get(idx);
                    top[1]++; // move to next neighbor

                    if (nei == parent[node]) continue;

                    if (!visited[nei]) {
                        parent[nei] = node;
                        childCount[node]++;
                        stack.push(new int[]{nei, 0});
                    } else {
                        low[node] = Math.min(low[node], tin[nei]);
                    }
                } else {
                    stack.pop();

                    if (parent[node] != -1) {
                        low[parent[node]] = Math.min(low[parent[node]], low[node]);

                        if (low[node] >= tin[parent[node]]) {
                            isAP[parent[node]] = true;
                        }
                    }
                }
            }

            // Root articulation condition
            if (childCount[start] > 1) {
                isAP[start] = true;
            } else {
                isAP[start] = false; // ensure correct
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i]) res.add(i);
        }

        if (res.size() == 0) res.add(-1);
        return res;
    }
}