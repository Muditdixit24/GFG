// User function Template for Java

class Sol {
    public static int maxOnes(int Mat[][], int N, int M) {
        // your code here
        //  N=mat.length;
        //  M=mat[0].length;
        int row=-1;
        int j=M-1;
        for(int i=0;i<N;i++){
            while(j>=0&&Mat[i][j]==1){
                j--;
                row=i;
            }
        }
        return row;
    }
}