/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node compute(Node head) {
        head = reverse(head);

        Node curr = head;
        int maxSoFar = curr.data;

        while (curr != null && curr.next != null) {
            if (curr.next.data < maxSoFar) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                maxSoFar = curr.data;
            }
        }

        return reverse(head);
    }

    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}