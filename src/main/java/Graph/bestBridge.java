package Graph;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayDeque;


// Have to find the starting island, then BFS from each pos in starting island looking for an L that isn't in the starting island
class Source {
    public static int bestBridge(List<List<String>> grid) {
        HashSet<List<Integer>> island1 = new HashSet<>();
        island1 = findIsland(island1, grid, new HashSet<>());
        // System.out.println(island1);
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
        HashSet<List<Integer>> visited = new HashSet<>();

        for (List<Integer> pos : island1) {
            int row = pos.get(0);
            int col = pos.get(1);
            queue.add(List.of(row, col, -1));
        }

        while (!queue.isEmpty()) {
            List<Integer> curr = queue.remove();
            int row = curr.get(0);
            int col = curr.get(1);
            int dist = curr.get(2);
            if (row < 0 || row >= grid.size() || col < 0 || col >= grid.get(0).size()) {
                continue;
            }
            if (grid.get(row).get(col) == "L" && !island1.contains(List.of(row, col))) {
                return dist;
            }
            if (visited.contains(List.of(row, col))) {
                continue;
            }
            visited.add(List.of(row, col));
            queue.add(List.of(row, col - 1, dist + 1));
            queue.add(List.of(row, col + 1, dist + 1));
            queue.add(List.of(row - 1, col, dist + 1));
            queue.add(List.of(row + 1, col, dist + 1));
        }
        return -1;
    }

    public static HashSet<List<Integer>> findIsland(HashSet<List<Integer>> island, List<List<String>> grid, HashSet<List<Integer>> visited) {
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                if (grid.get(row).get(col) == "L") {
                    explore(island, grid, row, col, visited);
                    return island;
                }
            }
        }
        return island;
    }

    public static void explore(HashSet<List<Integer>> island, List<List<String>> grid, int row, int col, HashSet<List<Integer>> visited) {
        if (row < 0 || row >= grid.size() || col < 0 || col >= grid.get(0).size()) {
            return;
        }
        if (visited.contains(List.of(row, col))) {
            return;
        }
        visited.add(List.of(row, col));

        if (grid.get(row).get(col) == "L") {
            island.add(List.of(row, col));
            explore(island, grid, row - 1, col, visited);
            explore(island, grid, row + 1, col, visited);
            explore(island, grid, row, col - 1, visited);
            explore(island, grid, row, col + 1, visited);
        }

        return;
    }