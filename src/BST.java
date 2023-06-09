import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;
    // Node class representing a node in the BST
    class Node {
        K key;
        V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
    // Inserts a key-value pair into the BST
    public void put(K key, V val) {
        root = put(root, key, val);
    }
    // Recursive helper method for put()
    private Node put(Node node, K key, V val) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }

        return node;
    }
    // Retrieves the value associated with a given key from the BST
    public V get(K key) {
        return get(root, key);
    }
    // Recursive helper method for get()
    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.val;
        }
    }
    // Deletes a key-value pair from the BST
    public void delete(K key) {
        root = delete(root, key);
    }
    // Recursive helper method for delete()
    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            } else {
                Node minNode = findMin(node.right);
                node.key = minNode.key;
                node.val = minNode.val;
                node.right = deleteMin(node.right);
            }
        }

        return node;
    }
    // Finds the minimum node in a given subtree
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    // Deletes the minimum node from a given subtree
    private Node deleteMin(Node node) {
        if (node.left == null) {
            size--;
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
    // Returns an iterable collection of nodes in the BST
    public Iterable<Node> iterator() {
        List<Node> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);
        return nodes;
    }
    // Performs an inorder traversal of the BST and populates the list of nodes
    private void inorderTraversal(Node node, List<Node> nodes) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, nodes);
        nodes.add(node);
        inorderTraversal(node.right, nodes);
    }
    // Returns the size of the BST
    public int size() {
        return size;
    }

    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node root, K key) {
        if (root == null) {
            return false;
        }
        int cmp = key.compareTo(root.key);

        if (cmp < 0) {
            return contains(root.left, key);
        } else if (cmp > 0) {
            return contains(root.right, key);
        }else{
            return true;
        }
    }
}
