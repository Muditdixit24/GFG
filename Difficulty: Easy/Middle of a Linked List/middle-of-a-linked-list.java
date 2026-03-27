/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    int getMiddle(Node head) {
        
        // code here
        if(head==null){
            return -1;
        }
        Node slow=head;
        Node fast = head;
        while(fast!=null&& fast.next!= null){
            slow=slow.next;
            fast= fast.next.next;
        }
        return slow.data;
       
    }
     
}