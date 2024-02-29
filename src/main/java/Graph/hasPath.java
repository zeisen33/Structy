package Graph;

// Similar traversal as binary tress.
// Nodes point to a list of other nodes.

import java.util.Map;
import java.util.List;

class Source {
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
