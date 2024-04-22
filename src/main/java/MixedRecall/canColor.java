package MixedRecall;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

class Source {
    public static boolean canColor(Map<String, List<String>> graph) {
        HashMap<String, Boolean> visited = new HashMap<>();

        for (String start : graph.keySet()) {
            if (!visited.containsKey(start)) {
                if (explore(graph, visited, true, start)) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean explore(Map<String, List<String>> graph, HashMap<String, Boolean> visited, Boolean curr, String start) {
        System.out.println(visited);
        System.out.println(start);
        System.out.println(curr);
        if (visited.containsKey(start)) {
            if (curr != visited.get(start)) {
                return false;
            } else {
                return true;
            }
        }
        visited.put(start, curr);

        for (String neighbor : graph.get(start)) {
            if (explore(graph, visited, !curr, neighbor)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
