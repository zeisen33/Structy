package MixedRecall;

class Source {
    public static Node<String> buildTreeInPre(List<String> inOrder, List<String> preOrder) {
        if (inOrder.size() == 0) {
            return null;
        }
        if (inOrder.size() == 1 && preOrder.size() == 1) {
            return new Node<String>(inOrder.get(0));
        }

        String midVal = preOrder.get(0);
        int midIdx = inOrder.indexOf(midVal);
        Node<String> left = buildTreeInPre(inOrder.subList(0, midIdx), preOrder.subList(1, midIdx + 1));
        Node<String> right = buildTreeInPre(inOrder.subList(midIdx + 1, inOrder.size()), preOrder.subList(midIdx + 1, inOrder.size()));
        Node<String> root = new Node<String>(midVal);
        root.left = left;
        root.right = right;
        return root;
    }
