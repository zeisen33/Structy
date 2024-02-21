package BinaryTree;// Write a method, maxPathSum, that takes in the root of a binary tree that contains number values. The method should return the maximum sum of any root to leaf path within the tree.
//
// You may assume that the input tree is non-empty.

class Node<T> {
    T val;
    Node<T> left;
    Node<T> right;

    public Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
class Source {
    public static Double maxPathSum(Node<Double> root) {
        Double maxSum = 0.0;
        if (root == null) {
            return Double.NEGATIVE_INFINITY;
        }
        maxSum += root.val;
        if (root.left == null && root.right == null) {
            return maxSum;
        } else {
            return maxSum + Math.max(maxPathSum(root.left), maxPathSum(root.right));
        }
    }
}
