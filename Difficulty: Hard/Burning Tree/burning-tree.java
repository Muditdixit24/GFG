

class Solution {

    public static int minTime(Node root, int target) {
        
        
        HashMap<Node, Node> parent = new HashMap<>();
        Node targetNode = buildParent(root, parent, target);
        
        
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        
        q.offer(targetNode);
        visited.add(targetNode);
        
        int time = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            boolean burned = false;
            
            for(int i = 0; i < size; i++){
                
                Node curr = q.poll();
                
                
                if(curr.left != null && !visited.contains(curr.left)){
                    q.offer(curr.left);
                    visited.add(curr.left);
                    burned = true;
                }
                
               
                if(curr.right != null && !visited.contains(curr.right)){
                    q.offer(curr.right);
                    visited.add(curr.right);
                    burned = true;
                }
                
                
                if(parent.get(curr) != null && !visited.contains(parent.get(curr))){
                    q.offer(parent.get(curr));
                    visited.add(parent.get(curr));
                    burned = true;
                }
            }
            
            if(burned) time++;
        }
        
        return time;
    }
    
    
    static Node buildParent(Node root, HashMap<Node, Node> parent, int target){
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        Node targetNode = null;
        
        while(!q.isEmpty()){
            
            Node curr = q.poll();
            
            if(curr.data == target){
                targetNode = curr;
            }
            
            if(curr.left != null){
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            
            if(curr.right != null){
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        
        return targetNode;
    }
}