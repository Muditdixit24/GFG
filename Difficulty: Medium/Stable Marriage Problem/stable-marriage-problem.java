class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        
        int n = men.length;

        int[] partnerW = new int[n];   // woman -> man
        int[] result = new int[n];     // man -> woman
        int[] next = new int[n];       // next woman index to propose

        Arrays.fill(partnerW, -1);

        // rank[w][m] = preference rank of man m for woman w
        int[][] rank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }

        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) freeMen.add(i);

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();

            int w = men[m][next[m]];
            next[m]++;

            if (partnerW[w] == -1) {
                // woman is free
                partnerW[w] = m;
                result[m] = w;
            } else {
                int m1 = partnerW[w];

                // check if woman prefers new man
                if (rank[w][m] < rank[w][m1]) {
                    partnerW[w] = m;
                    result[m] = w;
                    freeMen.add(m1);  // old man becomes free
                } else {
                    freeMen.add(m);   // rejected
                }
            }
        }

        return result;
    }
}