package Graph;

import java.util.Map;
import java.util.List;

class Source {
    public static int longestPath(Map<String, List<String>> graph) {
        int max = 0;
        for (String node : graph.keySet()) {
            int count = longestPathFrom(graph, node);
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static int longestPathFrom(Map<String, List<String>> graph, String startNode) {
        List<String> neighbors = graph.get(startNode);
        if (neighbors.size() == 0) {
            return 0;
        }
        int max = 0;
        for (String neighbor : neighbors) {
            int result = longestPathFrom(graph, neighbor);
            if (result > max) {
                max = result;
            }
        }
        return 1 + max;
    }
