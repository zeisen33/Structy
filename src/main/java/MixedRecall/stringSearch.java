package MixedRecall;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

class Source {
    public static boolean stringSearch(List<List<String>> grid, String s) {
        for (int row = 0; row < grid.size(); row++) {
            for (int col = 0; col < grid.get(0).size(); col++) {
                if (grid.get(row).get(col).equals(String.valueOf(s.charAt(0)))) {
                    // System.out.println("checking " + row + ", " + col);
                    if (searchFromStart(grid, s, row, col, new HashMap<List<Integer>, Boolean>())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean searchFromStart(List<List<String>> grid, String s, int row, int col, HashMap<List<Integer>, Boolean> visited) {
        if (row < 0 || row >= grid.size() || col < 0 || col >= grid.get(0).size()) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        if (visited.containsKey(List.of(row, col, s.length()))) {
            return visited.get(List.of(row, col, s.length()));
        }

        if (!String.valueOf(s.charAt(0)).equals(grid.get(row).get(col))) {
            return false;
        }

        List<List<Integer>> options = List.of(List.of(0, 1),
                List.of(0, -1),
                List.of(1, 0),
                List.of(-1, 0));
        for (List<Integer> option : options) {
            if (searchFromStart(grid, s.substring(1, s.length()), row + option.get(0), col + option.get(1), visited)) {
                visited.put(List.of(row, col, s.length()), true);
                return true;
            } else {
                visited.put(List.of(row, col, s.length()), false);
            }
        }

        visited.put(List.of(row, col, s.length()), false);
        return false;
    }