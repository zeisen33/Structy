import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// Node class is named already inside maxPathSum so this errors.
//class Node<T> {
//    T val;
//    Node<T> left;
//    Node<T> right;
//
//    public Node(T val) {
//        this.val = val;
//        this.left = null;
//        this.right = null;
//    }
//}

class Source {
    public static <T> List<T> pathFinder(Node<T> root, T target) {
        if (root == null) {
            return null;
        }

        if (root.val == target) {
            return List.of(root.val);
        }

        ArrayList<T> finalList = new ArrayList<>();

        finalList.add(root.val);
        finalList.addAll(pathFinder(root.left, target));
        finalList.addAll(pathFinder(root.right, target));

        return Collections.reverse(finalList);
    }
}


