package Graph;

import java.util.List;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Source {
    public static int semestersRequired(int numCourses, List<List<Integer>> prereqs) {
        if (prereqs.size() == 0) {
            return 1;
        }
        Map<Integer, List<Integer>> graph = buildGraph(prereqs);
        HashMap<Integer, Integer> visited = new HashMap<>();
        int max = 0;

        // System.out.println(graph);
        for (Integer course : graph.keySet()) {
            // System.out.println(course);
            int courseLongest = longestPath(course, graph, visited);
            System.out.println(courseLongest);
            if (courseLongest > max) {
                max = courseLongest;
            }
        }
        return max;
    }

    public static int longestPath(Integer course, Map<Integer, List<Integer>> graph, Map<Integer, Integer> visited) {
        // System.out.println(course);
        if (visited.containsKey(course)) {
            return visited.get(course);
        }
        // visited.put(course, 1);
        if (!graph.containsKey(course)) {
            return 1;
        }


        int max = 0;

        for (Integer prereq : graph.get(course)) {
            // System.out.println(prereq);
            int prereqCount = longestPath(prereq, graph, visited);
            visited.put(prereq, prereqCount);
            if (prereqCount > max) {
                max = prereqCount;
            }
        }
        return 1 + max;
    }

    public static Map<Integer, List<Integer>> buildGraph(List<List<Integer>> prereqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> req : prereqs) {
            if (!graph.containsKey(req.get(0))) {
                graph.put(req.get(0), new ArrayList<Integer>());
            }
            graph.get(req.get(0)).add(req.get(1));
        }
        return graph;
    }