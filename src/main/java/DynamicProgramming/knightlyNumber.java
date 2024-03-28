package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.List;
import java.util.HashMap;

class Source {


    // Times out because there's no way to memoize this problem with BFS
    public static int knightlyNumber(int n, int m, int kr, int kc, int pr, int pc)  {
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
        queue.add(List.of(kr, kc, 0));
        int count = 0;

        while (!queue.isEmpty()) {
            List<Integer> curr = queue.remove();
            int row = curr.get(0);
            int col = curr.get(1);
            int moves = curr.get(2);
            if (row < 0 || row >= n) {
                continue;
            }
            if (col < 0 || col >= n) {
                continue;
            }
            if (moves == m && row == pr && col == pc) {
                count++;
            }
            if (moves > m) {
                break;
            }

            queue.add(List.of(row + 2, col + 1, moves + 1));
            queue.add(List.of(row + 2, col - 1, moves + 1));
            queue.add(List.of(row - 2, col + 1, moves + 1));
            queue.add(List.of(row - 2, col - 1, moves + 1));
            queue.add(List.of(row + 1, col + 2, moves + 1));
            queue.add(List.of(row + 1, col - 2, moves + 1));
            queue.add(List.of(row - 1, col + 2, moves + 1));
            queue.add(List.of(row - 1, col - 2, moves + 1));
        }
        return count;
    }
