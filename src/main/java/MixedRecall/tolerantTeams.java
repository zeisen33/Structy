package MixedRecall;

import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

// Check if a graph is Bipartite, ie can be split in two

class Source {
    public static boolean tolerantTeams(List<List<String>> rivalries) {
        // System.out.println(buildGraph(rivalries));
        HashMap<String, HashSet<String>> graph = buildGraph(rivalries);
        HashMap<String, Boolean> visited = new HashMap<>();

        for (String start : graph.keySet()) {
            if (!visited.containsKey(start)) {
                if (!isValid(graph, start, visited, false)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean isValid(HashMap<String, HashSet<String>> graph, String start, HashMap<String, Boolean> visited, Boolean curr) {
        if (visited.containsKey(start)) {
            return curr == visited.get(start);
        }
        visited.put(start, curr);

        for (String neighbor : graph.get(start)) {
            if (!isValid(graph, neighbor, visited, !curr)) {
                return false;
            }
        }
        return true;
    }




    public static HashMap<String, HashSet<String>> buildGraph(List<List<String>> edges) {
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        for (List<String> edge : edges) {
            String first = edge.get(0);
            String second = edge.get(1);

            if (!graph.containsKey(first)) {
                graph.put(first, new HashSet<String>());
            }
            if (!graph.containsKey(second)) {
                graph.put(second, new HashSet<String>());
            }

            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        return graph;
    }