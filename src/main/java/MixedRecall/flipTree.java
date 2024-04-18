package MixedRecall;

class Source {
    public static Node<String> flipTree(Node<String> root) {
        Node<String> dummyHead = root;
        flipRecursion(root);

        return dummyHead;
    }

    public static void flipRecursion(Node<String> root) {
        if (root == null) {
            return;
        }

        Node<String> temp = root.right;
        root.right = root.left;
        root.left = temp;

        flipTree(root.right);
        flipTree(root.left);
    }