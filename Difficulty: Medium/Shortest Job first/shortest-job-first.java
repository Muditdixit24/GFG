// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        Arrays.sort(bt);
        int n= bt.length;
        int t=0;
        int wt=0;
        for(int i=0;i<bt.length;i++){
            wt= wt+t;
            t=t+bt[i];
        }
        return wt/n;
    }
}
