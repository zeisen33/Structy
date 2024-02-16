import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
    public static <T> List<T> pathFinder(Node<T> root, T target) {
        List<T> path = pathFinderRecursive(root, target);
        if (path == null) {
            return null;
        } else {
            Collections.reverse(path);
            return path;
        }
    }

    public static <T> List<T> pathFinderRecursive(Node<T> root, T target) {
        if (root == null) {
            return null;
        }


        if (root.val == target) {
            ArrayList<T> list = new ArrayList<>();
            list.add(root.val);
            return list;
        }

        List<T> leftPath = pathFinderRecursive(root.left, target);
        if (leftPath != null) {
            leftPath.add(root.val);
            return leftPath;
        }
        List<T> rightPath = pathFinderRecursive(root.right, target);
        if (rightPath != null) {
            rightPath.add(root.val);
            return rightPath;
        }

        return null;
    }

    public static void run() {
        // this function behaves as `main()` for the 'run' command
        // you may sandbox in this function , but should not remove it
    }
}


