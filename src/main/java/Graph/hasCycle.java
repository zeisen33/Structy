package Graph;

import java.util.Map;
import java.util.List;
import java.util.HashSet;


// This is known as white-grey-black algorithm. Keep track of inProgress and visited.
// If reach a visited, move to next. If reach an inProgress, return true. After visiting,
// add to inProgress. After the whole search is done, add everything from inProgress
// into visited then move to the next starting node.
class Source {
    public static boolean hasCycle(Map<String, List<String>> graph) {
        HashSet<String> inProgress = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        for (String node : graph.keySet()) {
            if (explore(node, inProgress, visited, graph)) {
                return true;
            }
            // Below is not consistent, depends on graph.keySet() order. Fails Tests 1 and 6 if a is first
            // because checking b adds c to inProgress, then checks C.
//            visited.addAll(inProgress);
//            inProgress.clear();
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
        // Have to clear inProgress and add to visited here
        inProgress.remove(node);
        visited.add(node);
        return false;
    }
