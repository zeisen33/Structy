package MixedRecall;

// Times out
class Source {
    public static List<String> topologicalOrder(Map<String, List<String>> graph) {
        List<String> allNodes = new ArrayList<>();
        String nextNode = null;
        List<String> output = new ArrayList<>();
        System.out.println(graph);
        if (graph == null) {
            return List.of();
        }

        for (List<String> neighborsList : graph.values()) {
            for (String neighbor : neighborsList) {
                allNodes.add(neighbor);
            }
        }

        for (String node : graph.keySet()) {
            if (!allNodes.contains(node)) {
                nextNode = node;
                break;
            }
        }

        output.add(nextNode);

        Map<String, List<String>> nextGraph = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            if (entry.getKey() == nextNode) {
                continue;
            } else {
                nextGraph.put(entry.getKey(), entry.getValue());
            }
        }


        output.addAll(topologicalOrder(nextGraph));



        return output;
    }

    // Works
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;


    class Source {
        public static List<String> topologicalOrder(Map<String, List<String>> graph) {
            HashMap<String, Integer> numParents = new HashMap<>();
            for (String node : graph.keySet()) {
                numParents.put(node, 0);
            }

            for (List<String> neighborList : graph.values()) {
                for (String neighbor : neighborList) {
                    numParents.put(neighbor, numParents.get(neighbor) + 1);
                }
            }

            List<String> output = new ArrayList<>();

            while (numParents.values().contains(0)) {
                for (String node : numParents.keySet()) {
                    if (numParents.get(node) == 0) {
                        numParents.put(node, -1);
                        output.add(node);
                        for (String neighbor : graph.get(node)) {
                            numParents.put(neighbor, numParents.get(neighbor) - 1);
                        }
                    }
                }
            }

            // System.out.println(numParents);


            return output;
        }