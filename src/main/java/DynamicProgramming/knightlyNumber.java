package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.List;
import java.util.HashMap;



class Source {
    // Works recursively bc able to memoize since you run the same calculation multiple times.
    public static int knightlyNumber(int n, int m, int kr, int kc, int pr, int pc)  {

        return knightlyNumber(n, m, kr, kc, pr, pc, new HashMap<List<Integer>, Integer>());
    }

    public static int knightlyNumber(int n, int m, int kr, int kc, int pr, int pc, HashMap<List<Integer>, Integer> memo) {
        System.out.println(kr + ", " + kc);
        if (m == 0 && kr == pr && kc == pc) {
            return 1;
        }
        if (m < 0) {
            return 0;
        }
        if (kr < 0 || kr >= n || kc < 0 || kc >= n) {
            return 0;
        }
        if (memo.containsKey(List.of(kr, kc, m))) {
            return memo.get(List.of(kr, kc, m));
        }

        List<List<Integer>> moves = List.of(List.of(1,2), List.of(1, -2), List.of(2, 1), List.of(2,-1), List.of(-1, 2), List.of(-1, -2), List.of(-2, 1), List.of(-2, -1));

        int sum = 0;
        for (List<Integer> move : moves) {
            int nr = kr + move.get(0);
            int nc = kc + move.get(1);
            sum += knightlyNumber(n, m - 1, nr, nc, pr, pc, memo);
        }
        memo.put(List.of(kr, kc, m), sum);
        return sum;
    }


    // Times out because there's no way to memoize this problem with BFS as you dont ever repeat calculations
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
