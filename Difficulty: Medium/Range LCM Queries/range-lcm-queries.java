import java.util.*;

class Solution {
    
    long[] segTree;
    
    long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    
    void build(int node, int start, int end, int[] arr) {
        
        if (start == end) {
            segTree[node] = arr[start];
            return;
        }
        
        int mid = (start + end) / 2;
        
        build(2 * node, start, mid, arr);
        build(2 * node + 1, mid + 1, end, arr);
        
        segTree[node] = lcm(segTree[2 * node], segTree[2 * node + 1]);
    }
    
    void update(int node, int start, int end, int idx, int val) {
        
        if (start == end) {
            segTree[node] = val;
            return;
        }
        
        int mid = (start + end) / 2;
        
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } 
        else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        
        segTree[node] = lcm(segTree[2 * node], segTree[2 * node + 1]);
    }
    
    long query(int node, int start, int end, int l, int r) {
        
        if (r < start || end < l) {
            return 1;
        }
        
        if (l <= start && end <= r) {
            return segTree[node];
        }
        
        int mid = (start + end) / 2;
        
        long left = query(2 * node, start, mid, l, r);
        long right = query(2 * node + 1, mid + 1, end, l, r);
        
        return lcm(left, right);
    }
    
    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        
        int n = arr.length;
        
        segTree = new long[4 * n];
        
        build(1, 0, n - 1, arr);
        
        ArrayList<Long> ans = new ArrayList<>();
        
        for (int[] q : queries) {
            
            // Update Query
            if (q[0] == 1) {
                
                int index = q[1];
                int value = q[2];
                
                update(1, 0, n - 1, index, value);
            }
            
            // Range Query
            else {
                
                int l = q[1];
                int r = q[2];
                
                ans.add(query(1, 0, n - 1, l, r));
            }
        }
        
        return ans;
    }
}