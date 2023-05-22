# assignment5 documentation <img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>
Here is full explanation of methods 
--------    ---------    --------
<b><p>BST class<p></b>
<b>Description:</b> 
 * *The BST class represents a binary search tree data structure, that allows efficient insertion, retrieval, and deletion of key-value pairs, where keys are comparable. It supports generic types for both keys and values.*
 * *@param <<K>K> the type of keys in the BST, must implement the Comparable interface*
 * *@param <<V>V> the type of values in the BST*<br><br>
<b>Methods of class:</b><br>
<b><p> :one: put<p></b>
<b>Description:</b> *Inserts a key-value pair into the binary search tree.*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
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
```
--------    ---------    --------
  <b><p> :two: get<p></b>
<b>Description:</b> *method used to retrieve the value associated with the given key from the binary search tree.*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
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
```
--------    ---------    --------
   <b><p> :three: delete<p></b>
<b>Description:</b> *method used to delete the key-value pair with the given key from the binary search tree.*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
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
```
--------    ---------    --------
   <b><p> :four: iterator<p></b>
<b>Description:</b> *returns an iterable collection of nodes in the binary search tree, using an inorder traversal.*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
   // Returns an iterable collection of nodes in the BST
    public Iterable<Node> iterator() {
        List<Node> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);
        return nodes;
    }
```
--------    ---------    --------
   <b><p> :five: inorderTraversal<p></b>
<b>Description:</b> *performs an inorder traversal of the binary search tree and populates the list of node.*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
   // Performs an inorder traversal of the BST and populates the list of nodes
    private void inorderTraversal(Node node, List<Node> nodes) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, nodes);
        nodes.add(node);
        inorderTraversal(node.right, nodes);
    }
```
--------    ---------    --------
  <b><p> :six: size<p></b>
<b>Description:</b> *returns the size of the binary search tree.*<br><br>
<b>Full code with some comments:</b>:white_check_mark:
```
   // Returns the size of the BST
    public int size() {
        return size;
    }
```
--------    ---------    --------
