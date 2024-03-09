package Graph;

import java.util.Map;
import java.util.List;
import java.util.HashSet;

class Source {
    public static boolean hasCycle(Map<String, List<String>> graph) {
        HashSet<String> inProgress = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        for (String node : graph.keySet()) {
            if (explore(node, inProgress, visited, graph)) {
                return true;
            }
            visited.addAll(inProgress);
            inProgress.clear();
        }
        return false;
    }

    public static boolean explore(String node, HashSet<String> inProgress, HashSet<String> visited, Map<String, List<String>> graph) {
        if (inProgress.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }
        if (graph.get(node).size() == 0) {
            return false;
        }
        inProgress.add(node);
        for (String neighbor : graph.get(node)) {
            if (explore(neighbor, inProgress, visited, graph)) {
                return true;
            }
        }
        return false;
    }
