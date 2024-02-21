package BinaryTree;

import java.util.ArrayDeque;

class Source {
        public static <T> int treeValueCount(Node<T> root, T target) {
            if (root == null) {
                return 0;
            }
            int count = 0;

            ArrayDeque<Node<T>> queue = new ArrayDeque<Node<T>>();
            queue.push(root);

            while (!queue.isEmpty()) {
                Node<T> current = queue.pop();
                if (current.val == target) {
                    count++;
                }
                if (current.left != null) {
                    queue.push(current.left);
                }
                if (current.right != null) {
                    queue.push(current.right);
                }
            }

            return count;
        }
}
