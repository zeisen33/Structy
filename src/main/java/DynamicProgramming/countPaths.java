package DynamicProgramming;

import java.util.List;
import java.util.HashMap;

class Source {
    public static int countPaths(List<List<String>> grid) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> start = List.of(0, 0);

        return countPaths(start, map, grid);
    }
    public static int countPaths(List<Integer> start, HashMap<List<Integer>, Integer> map, List<List<String>> grid) {
        int row = start.get(0);
        int col = start.get(1);

        if (row < 0 || row >= grid.size() || col < 0 || col >= grid.get(0).size()) {
            return 0;
        }
        if (map.containsKey(start)) {
            return map.get(start);
        }
        if (grid.get(row).get(col) == "X") {
            return 0;
        }
        if (row == grid.size() - 1 && col == grid.get(0).size() - 1) {
            return 1;
        }

        int down = countPaths(List.of(row + 1, col), map, grid);
        int right = countPaths(List.of(row, col + 1), map, grid);
        int res = down + right;
        map.put(start, res);
        return res;
    }