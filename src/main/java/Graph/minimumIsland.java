package Graph;
import java.util.List;
import java.util.HashSet;
import java.util.AbstractMap.SimpleEntry;


class Source {
    public static int minimumIsland(List<List<String>> grid) {
        double minCount = Double.POSITIVE_INFINITY;
        HashSet<SimpleEntry<Integer, Integer>> visited = new HashSet<>();

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                int subCount = explore(i, j, visited, grid);
                if (subCount < minCount && subCount > 0) {
                    minCount = subCount;
                }
            }
        }

        return (int)minCount;
    }

    public static int explore(int row, int col, HashSet<SimpleEntry<Integer, Integer>> visited, List<List<String>> grid) {
        if (row < 0 || row >= grid.size()) {
            return 0;
        }
        if (col < 0 || col >= grid.get(0).size()) {
            return 0;
        }
        SimpleEntry<Integer, Integer> pos = new SimpleEntry<>(row, col);
        if (visited.contains(pos)) {
            return 0;
        }
        visited.add(pos);
        if (grid.get(row).get(col) == "W") {
            return 0;
        }
        return 1 + explore(row - 1, col, visited, grid) + explore(row + 1, col, visited, grid) + explore(row, col - 1, visited, grid) + explore(row, col + 1, visited, grid);
    }