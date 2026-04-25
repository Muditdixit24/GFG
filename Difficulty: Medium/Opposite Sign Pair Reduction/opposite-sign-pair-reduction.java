import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();

        for (int num : arr) {
            boolean alive = true;

            // handle BOTH opposite sign cases
            while (!st.isEmpty() && 
                  ((st.peekLast() > 0 && num < 0) || 
                   (st.peekLast() < 0 && num > 0))) {

                int top = st.peekLast();

                if (Math.abs(top) > Math.abs(num)) {
                    alive = false;
                    break;
                } 
                else if (Math.abs(top) < Math.abs(num)) {
                    st.removeLast();
                } 
                else {
                    st.removeLast();
                    alive = false;
                    break;
                }
            }

            if (alive) {
                st.addLast(num);
            }
        }

        return new ArrayList<>(st);
    }
}