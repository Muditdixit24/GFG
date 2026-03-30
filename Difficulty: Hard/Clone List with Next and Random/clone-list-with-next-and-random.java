/*
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/
class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
        if(head==null) return null;
        Node temp= head;
        while(temp!= null){
            Node copy=new Node(temp.data);
            copy.next=temp.next;
            temp.next=copy;
            temp=copy.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random= temp.random.next;
            }
            temp=temp.next.next;
        }
        temp=head;
        Node dummy= new Node(0);
        Node copytail=dummy;
        while(temp!=null){
            Node copy=temp.next;
            temp.next=copy.next;
            copytail.next=copy;
            copytail=copy;
            temp=temp.next;
        }
        return dummy.next;
    }
}