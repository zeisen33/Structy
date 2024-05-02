package MixedRecall;

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