package BinaryTree;
// Move into package


// Polynomial time because of the addAll

class Source {
    public static <T> List<T> leafList(Node<T> root) {
        if (root == null) {
            return List.of();
        }

        if (root.left == null && root.right == null) {
            return List.of(root.val);
        }

        List<T> leftPath = leafList(root.left);
        List<T> rightPath = leafList(root.right);
        List<T> finalList = new ArrayList<>();
        finalList.addAll(leftPath);
        finalList.addAll(rightPath);

        return finalList;
    }