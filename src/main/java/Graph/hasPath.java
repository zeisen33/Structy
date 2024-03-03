package Graph;

// Similar traversal as binary tress.
// Nodes point to a list of other nodes.
// List of other nodes can be empty.

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
}