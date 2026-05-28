class Solution {

    class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> verticalSum(Node root) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            Node node = curr.node;
            int hd = curr.hd;

            map.put(hd, map.getOrDefault(hd, 0) + node.data);

            if (node.left != null) {
                q.offer(new Pair(node.left, hd - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, hd + 1));
            }
        }

        return new ArrayList<>(map.values());
    }
}