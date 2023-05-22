public class Main {
    public static void main(String[] args) {
        // Create a binary search tree
        BST<Integer, String> tree = new BST<>();

        // Insert elements into the tree
        tree.put(5, "Arsen");
        tree.put(3, "Oraz");
        tree.put(7, "Rasul");
        tree.put(2, "Rakhat");

        // Iterate over the elements in the tree and print their keys and values
        for (BST.Node node : tree.iterator()) {
            System.out.println("Key is " + node.key + " and value is " + node.val);
        }
        // Delete element from the tree
        System.out.println();
        tree.delete(7);

        for (BST.Node node : tree.iterator()) {
            System.out.println("Key is " + node.key + " and value is " + node.val);
        }
    }
}
