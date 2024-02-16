class Source {
    public static <T> List<List<T>> allTreePaths(Node<T> root) {
        if (root == null) {
            return List.of();
        }

        if (root.left == null && root.right == null) {
            return List.of(List.of(root.val));
        }

        List<List<T>> allPaths = new ArrayList<>();

        List<List<T>> leftPath = allTreePaths(root.left);
        for (List<T> path : leftPath) {
            List<T> newPath = new ArrayList<>();
            newPath.add(root.val);
            newPath.addAll(path);
            allPaths.add(newPath);
        }

        List<List<T>> rightPath = allTreePaths(root.right);
        for (List<T> path : rightPath) {
            List<T> newPath = new ArrayList<>();
            newPath.add(root.val);
            newPath.addAll(path);
            allPaths.add(newPath);
        }

        return allPaths;
    }