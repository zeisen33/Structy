package MixedRecall;


import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

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
    public static String lowestCommonAncestor(Node<String> root, String val1, String val2) {
        ArrayList<String> path1 = getPath(root, val1);
        HashSet<String> path2 = new HashSet<>(getPath(root, val2));
        System.out.println(path1);
        System.out.println(path2);

        for (int i = 0; i < path1.size(); i++) {
            if (path2.contains(path1.get(i))) {
                return path1.get(i);
            }
        }
        return root.val;
    }

    public static ArrayList<String> getPath(Node<String> root, String val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            ArrayList<String> path = new ArrayList<>();
            path.add(val);
            return path;
        }

        ArrayList<String> leftPath = getPath(root.left, val);
        if (leftPath != null) {
            leftPath.add(root.val);
            return leftPath;
        }
        ArrayList<String> rightPath = getPath(root.right, val);
        if (rightPath != null) {
            rightPath.add(root.val);
            return rightPath;
        }
        return null;
    }
class Source {
    public static String lowestCommonAncestor(Node<String> root, String val1, String val2) {
        if (dfsContains(root.left, val1) && dfsContains(root.left, val2)) {
            return lowestCommonAncestor(root.left, val1, val2);
        } else if (dfsContains(root.right, val1) && dfsContains(root.right, val2)) {
            return lowestCommonAncestor(root.right, val1, val2);
        } else {
            return root.val;
        }
    }