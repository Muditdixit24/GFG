// User function Template for Java

/*The Node structure is defined as
struct Node {
    int data;
    Node *left;
    Node *right;

};
*/
class Solution {

    
        // Your code here
        int min=Integer.MAX_VALUE;
        Node prev;
        void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null){
            min=Math.min(min,root.data-prev.data);
        }
        prev=root;
        
        inorder(root.right);
    }
    
    public int absolute_diff(Node root) {
        prev=null;
        inorder(root);
        return min;
    }
}
