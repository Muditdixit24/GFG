class Solution {
    public Node addOne(Node head) {

        head = reverse(head);

        Node temp = head;
        int carry = 1;

        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;

            if (carry == 0) break;

            if (temp.next == null && carry == 1) {
                temp.next = new Node(1);
                carry = 0;
                break;
            }

            temp = temp.next;
        }

        head = reverse(head);
        return head;
    }

    private Node reverse(Node head) {
        Node prev = null, curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}