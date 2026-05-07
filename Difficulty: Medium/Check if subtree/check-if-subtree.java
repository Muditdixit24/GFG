/*
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/

class Solution {

    // Function to check if two trees are identical
    boolean isIdentical(Node a, Node b) {

        // Both are null
        if (a == null && b == null) {
            return true;
        }

        // One is null, other is not
        if (a == null || b == null) {
            return false;
        }

        // Check current node and both subtrees
        return (a.data == b.data)
                && isIdentical(a.left, b.left)
                && isIdentical(a.right, b.right);
    }

    // Function to check if S is subtree of T
    public boolean isSubTree(Node root1, Node root2) {

        // Empty tree is always subtree
        if (root2 == null) {
            return true;
        }

        // Main tree empty but subtree not empty
        if (root1 == null) {
            return false;
        }

        // If trees are identical
        if (isIdentical(root1, root2)) {
            return true;
        }

        // Check in left or right subtree
        return isSubTree(root1.left, root2)
                || isSubTree(root1.right, root2);
    }
}