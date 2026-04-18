class BST {

    Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    Node search(Node root, int key) {
        if (root == null || root.data == key)
            return root;

        if (key < root.data)
            return search(root.left, key);

        return search(root.right, key);
    }

    Node findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    Node delete(Node root, int val) {
        if (root == null) return null;

        if (val < root.data)
            root.left = delete(root.left, val);
        else if (val > root.data)
            root.right = delete(root.right, val);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node temp = findMin(root.right);
            root.data = temp.data;
            root.right = delete(root.right, temp.data);
        }
        return root;
    }
}
