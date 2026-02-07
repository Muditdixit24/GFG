import java.util.*;

class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;

        int bestDiff = Integer.MAX_VALUE;
        int bestSum = Integer.MAX_VALUE;

        int x = 0, y = 0, z = 0;

        while (i < a.length && j < b.length && k < c.length) {

            int A = a[i];
            int B = b[j];
            int C = c[k];

            int maxVal = Math.max(A, Math.max(B, C));
            int minVal = Math.min(A, Math.min(B, C));

            int diff = maxVal - minVal;
            int sum = A + B + C;

            // update best triplet
            if (diff < bestDiff || (diff == bestDiff && sum < bestSum)) {
                bestDiff = diff;
                bestSum = sum;
                x = A;
                y = B;
                z = C;
            }

            // move pointer of minimum element
            if (minVal == A) i++;
            else if (minVal == B) j++;
            else k++;
        }

        // sort result in decreasing order
        int[] ans = {x, y, z};
        Arrays.sort(ans);

        // reverse
        int temp = ans[0];
        ans[0] = ans[2];
        ans[2] = temp;

        return ans;
    }
}

