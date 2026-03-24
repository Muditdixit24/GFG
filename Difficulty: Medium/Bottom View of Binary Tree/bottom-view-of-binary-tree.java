/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            
            map.put(hd, node.data);

            if (node.left != null)
                q.add(new Pair(node.left, hd - 1));

            if (node.right != null)
                q.add(new Pair(node.right, hd + 1));
        }

        for (int val : map.values()) {
            res.add(val);
        }

        return res;
    }

    static class Pair {
        Node node;
        int hd;
        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }
}

