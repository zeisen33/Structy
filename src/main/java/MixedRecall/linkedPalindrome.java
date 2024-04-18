package MixedRecall;

import java.util.Stack;

class Node<T> {
    T val;
    Node<T> next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }
}

class Source {
    public static <T> boolean linkedPalindrome(Node<T> head) {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> curr = head;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        System.out.println(stack);

        curr = head;
        while (!stack.isEmpty()) {
            if (curr != stack.pop()) {
                return false;
            }
            curr = curr.next;
        }

        return true;
    }