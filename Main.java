public class Main {
    public static void main(String[] args) {

        BST tree = new BST();
        Traversal t = new Traversal();
        Node root = null;

        int arr[] = {50,30,70,20,40,60,80};

        for(int x : arr)
            root = tree.insert(root, x);

        System.out.print("Inorder: ");
        t.inorder(root);

        System.out.print("\nPreorder: ");
        t.preorder(root);

        System.out.print("\nPostorder: ");
        t.postorder(root);

        System.out.println("\nHeight: " + height(root));

        Node res = tree.search(root, 40);
        System.out.println("Search 40: " + (res != null));

        root = tree.delete(root, 30);
        System.out.print("After Deletion (Inorder): ");
        t.inorder(root);
    }

    static int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
