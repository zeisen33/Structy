package BinaryTree;

class Source {
    public static <T> int howHigh(Node<T> root) {
        if (root == null) {
            return -1;
        }

        int leftPath;
        int rightPath;
        leftPath = 1 + howHigh(root.left);
        rightPath = 1 + howHigh(root.right);
        return Math.max(leftPath, rightPath);
    }
}