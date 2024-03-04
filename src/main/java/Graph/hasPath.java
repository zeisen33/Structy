package Graph;

// Similar traversal as binary tress.
// Nodes point to a list of other nodes.
// List of other nodes can be empty.
// Start at source src, go to destination dst

import java.util.Map;
import java.util.List;

class Source {
    // Recursive DFS
    public static boolean hasPath(Map<String, List<String>> graph, String src, String dst) {
        if (src == dst) {
            return true;
        }
        for (String neighbor : graph.get(src)) {
            if (hasPath(graph, neighbor, dst)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPath(Map<String, List<String>> graph, String src, String dst) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            String current = queue.remove();
            if (current == dst) {
                return true;
            }
            for (String neighbor : graph.get(current)) {
                queue.add(neighbor);
            }
        }

        return false;
    }
}
