package MixedRecall;

class Source {
    public static Node<String> buildTreeInPost(List<String> inOrder, List<String> postOrder) {
        if (inOrder.size() == 0) {
            return null;
        }
        if (inOrder.size() == 1 && postOrder.size() == 1) {
            Node<String> node = new Node<>(inOrder.get(0));
            return node;
        }

        String rootVal = postOrder.get(postOrder.size() - 1);
        int midIdx = inOrder.indexOf(rootVal);

        Node<String> left = buildTreeInPost(inOrder.subList(0, midIdx), postOrder.subList(0, midIdx));
        Node<String> right = buildTreeInPost(inOrder.subList(midIdx + 1, inOrder.size()), postOrder.subList(midIdx, inOrder.size() - 1));
        Node<String> root = new Node<>(rootVal);
        root.left = left;
        root.right = right;
        return root;
    }