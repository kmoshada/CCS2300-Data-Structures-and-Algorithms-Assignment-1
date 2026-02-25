public class LocationBST {
    
    
    private class Node {
        String data;
        Node left, right;
        public Node(String data) { 
            this.data = data; 
        }
    }
    
    private Node root;

    // Add location to the tree
    public void insert(String data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, String data) {
        if (root == null) {
            return new Node(data);
        }
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Map all tree nodes into the Graph using In-Order Traversal
    public void mapToGraph(Graph graph) {
        inorderMap(root, graph);
        System.out.println("All locations from the BST have been mapped to the Graph!");
        root = null; // Clear the tree after mapping
    }

    private void inorderMap(Node root, Graph graph) {
        if (root != null) {
            inorderMap(root.left, graph);
            
            // Check if it already exists to avoid duplicates
            if (graph.getLocationByValue(root.data) == null) {
                graph.addLocation(root.data);
            }
            
            inorderMap(root.right, graph);
        }
    }
}