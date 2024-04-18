package MixedRecall;

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