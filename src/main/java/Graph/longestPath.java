package Graph;

import java.util.Map;
import java.util.List;
import java.util.HashMap;


// distance hashmap is for memoization
class Source {
    public static int longestPath(Map<String, List<String>> graph) {
        HashMap<String, Integer> distance = new HashMap<>();
        int max = 0;
        for (String node : graph.keySet()) {
            int count = longestPathFrom(graph, node, distance);
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static int longestPathFrom(Map<String, List<String>> graph, String startNode, HashMap<String, Integer> distance) {
        if (distance.containsKey(startNode)) {
            return distance.get(startNode);
        }
        List<String> neighbors = graph.get(startNode);
        if (neighbors.size() == 0) {
            return 0;
        }
        int max = 0;
        for (String neighbor : neighbors) {
            int result = longestPathFrom(graph, neighbor, distance);
            distance.put(neighbor, result);
            if (result > max) {
                max = result;
            }
        }
        return 1 + max;
    }
