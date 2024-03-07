package Graph;

import java.util.List;
import java.util.HashSet;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;


class Source {
    public static int closestCarrot(List<List<String>> grid, Integer startRow, Integer startCol) {
        List<Integer> startPos = new ArrayList<Integer>();
        startPos.add(startRow);
        startPos.add(startCol);

        HashSet<List<Integer>> visited = new HashSet<List<Integer>>();

        SimpleEntry<List<Integer>, Integer> startEntry = new SimpleEntry<List<Integer>, Integer>(startPos, 0);

        ArrayDeque<SimpleEntry<List<Integer>, Integer>> queue = new ArrayDeque<>();
        queue.add(startEntry);

        while (!queue.isEmpty()) {
            SimpleEntry<List<Integer>, Integer> curr = queue.remove();
            List<Integer> pos = curr.getKey();
            // System.out.println(pos);
            if (isOutOfBounds(pos, grid) || visited.contains(pos)) {
                continue;
            }
            // System.out.println("past check");
            Integer distance = curr.getValue();
            Integer row = pos.get(0);
            Integer col = pos.get(1);
            visited.add(pos);
            String val = grid.get(row).get(col);
            System.out.println(pos);
            System.out.println(val);
            if (val.equals("C")) {
                return distance;
            }
            if (val == "O") {
                queue.add(new SimpleEntry<List<Integer>, Integer>(List.of(row - 1, col), distance + 1));
                queue.add(new SimpleEntry<List<Integer>, Integer>(List.of(row + 1, col), distance + 1));
                queue.add(new SimpleEntry<List<Integer>, Integer>(List.of(row, col - 1), distance + 1));
                queue.add(new SimpleEntry<List<Integer>, Integer>(List.of(row, col + 1), distance + 1));
            }
        }

        return -1;
    }

    public static boolean isOutOfBounds(List<Integer> pos, List<List<String>> grid) {
        // System.out.println(pos);
        Integer row = pos.get(0);
        Integer col = pos.get(1);

        return row < 0 || row >= grid.size() || col < 0 || col >= grid.get(0).size();
    }