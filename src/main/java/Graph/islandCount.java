package Graph;

import java.util.List;
import java.util.HashSet;
import java.util.AbstractMap.SimpleEntry;


// O(#rows * #cols) because thats the max number of positions we check
class Source {
    public static int islandCount(List<List<String>> grid) {
        int count = 0;
        HashSet<SimpleEntry<Integer, Integer>> visited = new HashSet<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if (explore(i, j, grid, visited)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean explore(int row, int col, List<List<String>> grid, HashSet<SimpleEntry<Integer, Integer>> visited) {
        boolean rowInBounds = 0 <= row && row < grid.size();
        boolean colInBounds = 0 <= col && col < grid.get(0).size();
        if (!rowInBounds || !colInBounds) {
            return false;
        }
        if (grid.get(row).get(col) != "L") {
            return false;
        }
        SimpleEntry<Integer, Integer> pos = new SimpleEntry<>(row, col);
        if (visited.contains(pos)) {
            return false;
        }
        visited.add(pos);
        explore(row - 1, col, grid, visited);
        explore(row + 1, col, grid, visited);
        explore(row, col - 1, grid, visited);
        explore(row, col + 1, grid, visited);

        return true;
    }