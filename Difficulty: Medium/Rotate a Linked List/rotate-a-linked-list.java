class Solution {
    public Node findnode(Node temp, int k) {
        int count = 1;
        while (count < k) {
            temp = temp.next;
            count++;
        }
        return temp;
    }

    public Node rotate(Node head, int k) {
        if (head == null || k == 0) return head;

        Node tail = head;
        int len = 1;

        
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;
        if (k == 0) return head;

        
        Node newTail = findnode(head, k);

        Node newHead = newTail.next;

       
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}