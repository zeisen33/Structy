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
    public static List<String> leftyNodes(Node<String> root) {
        ArrayList<String> levels = new ArrayList<>();
        getLevels(root, levels, 0);

        return levels;
    }

    public static void getLevels(Node<String> root, ArrayList<String> levels, int currLevel) {
        if (root == null) {
            return;
        }
        if (levels.size() == currLevel) {
            levels.add(root.val);
        }
        getLevels(root.left, levels, currLevel + 1);
        getLevels(root.right, levels, currLevel + 1);

        return;
    }
