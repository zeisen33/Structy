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
    public static List<String> postOrder(Node<String> root) {
        List<String> vals = new ArrayList<>();
        traverse(root, vals);
        return vals;
    }

    public static void traverse(Node<String> root, List<String> vals) {
        if (root == null) {
            return;
        }

        traverse(root.left, vals);
        traverse(root.right, vals);
        vals.add(root.val);
    }