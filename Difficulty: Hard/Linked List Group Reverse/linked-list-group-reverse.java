class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null) return null;

        Node temp = head;
        Node prev = null;
        Node next = null;
        int count = 0;

       
        while (temp != null && count < k) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            count++;
        }

        
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}