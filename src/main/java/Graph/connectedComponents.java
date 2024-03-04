package Graph;
import java.util.Map;
import java.util.List;
import java.util.HashSet;
import java.util.Stack;


// A connected component is an island of nodes that is separated from the other nodes. This is asking for the number of node islands.
// O(e) time, O(n) space. Have to check every connection, but only need a visited, count, and stack of max space n.
class Source {
    public static int connectedComponentsCount(Map<Integer, List<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        Stack<Integer> stack = new Stack<>();

        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                count++;
                stack.push(node);
                while (!stack.isEmpty()) {
                    Integer current = stack.pop();
                    for (Integer neighbor : graph.get(current)) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
        return count;
    }
