package MixedRecall;

import java.util.HashSet;

class Node<T> {
    T val;
    Node<T> next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }
}

class Source {
    public static <T> boolean linkedListCycle(Node<T> head) {
        return linkedListCycleRecursive(head, new HashSet<Node<T>>());
    }

    public static <T> boolean linkedListCycleRecursive(Node<T> head, HashSet<Node<T>> visited) {
        if (head == null) {
            return false;
        }
        if (visited.contains(head)) {
            return true;
        }
        visited.add(head);
        return linkedListCycleRecursive(head.next, visited);
    }