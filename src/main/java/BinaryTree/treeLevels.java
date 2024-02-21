package BinaryTree;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
class Source {
    public static <T> List<List<T>> treeLevels(Node<T> root) {
        if (root == null) {
            return List.of();
        }
        List<List<T>> finalList = new ArrayList<>();
        ArrayDeque<SimpleEntry<Node<T>, Integer>> queue = new ArrayDeque<>();
        queue.add(new SimpleEntry<Node<T>, Integer>(root, 0));
        int currLevel = 0;
        List<T> subList = new ArrayList<>();


        while (!queue.isEmpty()) {
            SimpleEntry<Node<T>, Integer> entry = queue.remove();
            Node<T> node = entry.getKey();
            int level = entry.getValue();

            // if we're on the current level, add to sublist
            if (level == currLevel) {
                subList.add(node.val);
                // If not on current level, add the sublist to final and reset sublist with new node

            } else {
                finalList.add(subList);
                currLevel += 1;
                subList = new ArrayList<>();
                subList.add(node.val);
            }
            if (node.left != null) {
                queue.add(new SimpleEntry<Node<T>, Integer>(node.left, currLevel + 1));
            }
            if (node.right != null) {
                queue.add(new SimpleEntry<Node<T>, Integer>(node.right, currLevel + 1));
            }
        }

        finalList.add(subList);

        return finalList;
    }