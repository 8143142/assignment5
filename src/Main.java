public class Main {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        tree.put(5, "Arsen");
        tree.put(3, "Oraz");
        tree.put(7, "Rasul");
        tree.put(2, "Rakhat");

        for (BST.Node node : tree.iterator()) {
            System.out.println("Key is " + node.key + " and value is " + node.val);
        }

        System.out.println();
        tree.delete(7);

        for (BST.Node node : tree.iterator()) {
            System.out.println("Key is " + node.key + " and value is " + node.val);
        }
    }
}
