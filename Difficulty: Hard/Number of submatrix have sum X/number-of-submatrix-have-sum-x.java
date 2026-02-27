class Solution {
    public int countSquare(int[][] mat, int x) {
        
        int n = mat.length;
        int m = mat[0].length;
        
       
        int[][] prefix = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                
                prefix[i][j] = mat[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }
        
        int count = 0;
        
        
        for (int size = 1; size <= Math.min(n, m); size++) {
            
          
            for (int row = 0; row + size <= n; row++) {
                
                for (int col = 0; col + size <= m; col++) {
                    
                    
                    int sum = prefix[row + size][col + size]
                            - prefix[row][col + size]
                            - prefix[row + size][col]
                            + prefix[row][col];
                    
                    
                    if (sum == x) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}