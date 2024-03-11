package Graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

class Source {
    public static int knightAttack(int n, int kr, int kc, int pr, int pc) {
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
        HashSet<List<Integer>> visited = new HashSet<>();
        // List is row, col, dist
        queue.add(List.of(kr, kc, 0));

        while (!queue.isEmpty()) {
            List<Integer> curr = queue.remove();
            int row = curr.get(0);
            int col = curr.get(1);
            int dist = curr.get(2);
            if (row == pr && col == pc) {
                return dist;
            }
            if (row < 0 || row >= n || col < 0 || col >= n) {
                continue;
            }
            if (visited.contains(List.of(row, col))) {
                continue;
            }
            visited.add(List.of(row, col));
            queue.add(List.of(row + 2, col + 1, dist + 1));
            queue.add(List.of(row + 1, col + 2, dist + 1));
            queue.add(List.of(row + 1, col -2, dist + 1));
            queue.add(List.of(row + 2, col - 1, dist + 1));
            queue.add(List.of(row - 2, col + 1, dist + 1));
            queue.add(List.of(row - 1, col + 2, dist + 1));
            queue.add(List.of(row - 1, col - 2, dist + 1));
            queue.add(List.of(row - 2, col - 1, dist + 1));
        }

        return -1;
    }