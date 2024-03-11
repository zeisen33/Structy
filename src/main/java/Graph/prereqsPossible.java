package Graph;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

class Source {
    public static boolean prereqsPossible(int numCourses, List<List<Integer>> prereqs) {
        HashSet<Integer> inProgress = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();

        HashMap<Integer, List<Integer>> graph = buildGraph(prereqs, numCourses);
        // System.out.println(graph);
        for (Integer course : graph.keySet()) {
            if (explore(course, graph, inProgress, visited)) {
                return false;
            }
        }
        return true;
    }

    public static boolean explore(Integer course, HashMap<Integer, List<Integer>> graph, HashSet<Integer> inProgress, HashSet<Integer> visited) {
        if (visited.contains(course)) {
            return false;
        }
        if (inProgress.contains(course)) {
            return true;
        }
        inProgress.add(course);
        // if (graph.get(course).isEmpty()) {
        //   return false;
        // }

        // graph.get(course) returns null for empty list of neighbors. Need to explicitly add an empty list instead in graph construction.
        for (Integer neighbor : graph.get(course)) {
            if (explore(neighbor, graph, inProgress, visited)) {
                return true;
            }
        }
        inProgress.remove(course);
        visited.add(course);
        return false;
    }

    public static HashMap<Integer, List<Integer>> buildGraph(List<List<Integer>> prereqs, int numCourses) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int course = 0; course < numCourses; course++) {
            graph.put(course, new ArrayList<>());
        }
        for (List<Integer> pair : prereqs) {
            graph.get(pair.get(0)).add(pair.get(1));
        }
        return graph;
    }