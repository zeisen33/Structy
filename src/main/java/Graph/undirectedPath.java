package Graph;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ArrayDeque;

class Source {
    // BFS
    public static boolean undirectedPath(List<List<String>> edges, String nodeA, String nodeB) {
        Map<String, List<String>> graph = buildGraph(edges);
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();

        queue.add(nodeA);

        while (!queue.isEmpty()) {
            String current = queue.remove();
            if (current == nodeB) {
                return true;
            }
            List<String> neighbors = graph.get(current);
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return false;
    }

    public static Map<String, List<String>> buildGraph(List<List<String>> edges) {
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> edge : edges) {
            String first = edge.get(0);
            String second = edge.get(1);
            if (!graph.containsKey(first)) {
                graph.put(first, new ArrayList<>());
            }
            if (!graph.containsKey(second)) {
                graph.put(second, new ArrayList<>());
            }
            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        return graph;
    }