package MixedRecall;

import java.util.List;
import java.util.ArrayList;
class Node<T> {
    T val;
    Node<T> left;
    Node<T> right;

    public Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Source {
    public static boolean isBinarySearchTree(Node<Integer> root) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void inOrderTraversal(Node<Integer> root, List<Integer> values) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, values);
        values.add(root.val);
        inOrderTraversal(root.right, values);
    }