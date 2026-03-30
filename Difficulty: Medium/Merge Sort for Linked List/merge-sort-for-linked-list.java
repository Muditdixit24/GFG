/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node sort(Node list1,Node list2){
        Node dummy= new Node(-1);
        Node temp= dummy;
        while(list1!=null && list2!= null){
            if(list1.data<list2.data){
                temp.next=list1;
                temp=list1;
                list1=list1.next;
            }
            else{
                temp.next=list2;
                temp=list2;
                list2=list2.next;
            }
            
        }
        if(list1!= null) temp.next= list1;
        else temp.next= list2;
        return dummy.next;
    }
    public Node Middle(Node head){
        Node slow=head;
        Node fast= head.next;
        while(fast!=null&& fast.next!=null){
            slow=slow.next;
            fast =fast.next.next;
        }
        return slow;
    }
    public Node mergeSort(Node head) {
        if (head==null||head.next==null)return head;
        Node middle=Middle(head);
        Node right= middle.next;
        middle.next=null;
        Node left=head;
        left=mergeSort(left);
        right=mergeSort(right);
        return sort(left,right);
}
}