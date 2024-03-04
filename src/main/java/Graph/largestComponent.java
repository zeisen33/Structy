package Graph;

import java.util.Map;
import java.util.List;
import java.util.HashSet;

class Source {
    public static int largestComponent(Map<Integer, List<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        int max = 0;
        for (int node : graph.keySet()) {
            int size = countNodesInComponent(graph, node, visited);
            if (size > max) {
                max = size;
            }
        }

        return max;
    }

    public static int countNodesInComponent(Map<Integer, List<Integer>> graph, Integer node, HashSet<Integer> visited) {
        if (visited.contains(node)) {
            return 0;
        }
        visited.add(node);

        int count = 1;
        for (int neighbor : graph.get(node)) {
            count += countNodesInComponent(graph, neighbor, visited);
        }
        return count;
    }
