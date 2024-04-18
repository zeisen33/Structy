package MixedRecall;

import java.util.ArrayList;

class Node<T> {
    T val;
    Node<T> next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }
}

class Source {
    public static <T> T middleValue(Node<T> head) {
        ArrayList<T> vals = new ArrayList<>();
        Node<T> curr = head;

        while (curr != null) {
            vals.add(curr.val);
            curr = curr.next;
        }

        return vals.get(vals.size() / 2);
    }
