package DynamicProgramming;

import java.util.List;
import java.util.HashMap;

class Source {
    public static int maxPathSum(List<List<Integer>> grid) {
        HashMap<List<Integer>, Integer> memo = new HashMap<>();

        return maxPathSum(List.of(0, 0), grid, memo);
    }
    public static int maxPathSum(List<Integer> start, List<List<Integer>> grid, HashMap<List<Integer>, Integer> memo) {
        int row = start.get(0);
        int col = start.get(1);

        if (row < 0 || row >= grid.size() || col < 0 || col >= grid.get(0).size()) {
            return 0;
        }
        if (row == grid.size() - 1 && col == grid.get(0).size() - 1) {
            return grid.get(row).get(col);
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        int down = maxPathSum(List.of(row + 1, col), grid, memo);
        int right = maxPathSum(List.of(row, col + 1), grid, memo);
        int max = Math.max(down, right);
        int res = grid.get(row).get(col);

        memo.put(start, res + max);
        return res + max;
    }
