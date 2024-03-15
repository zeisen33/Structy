package DynamicProgramming;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Source {
    public static int summingSquares(int n) {
        List<Integer> squares = getSmallerSquares(n);
        return summingSquares(n, squares, new HashMap<Integer, Integer>());
    }
    public static int summingSquares(int n, List<Integer> squares, HashMap<Integer,Integer> memo) {
        if (n == 0) {
            return 0;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int minNum = -1;
        for (Integer sqr : squares) {
            int diff = n - sqr;
            int subNum = 0;
            if (diff >= 0) {
                subNum = 1 + summingSquares(diff, squares, memo);
            }
            if (subNum != 0) {
                if (subNum < minNum || minNum == -1) {
                    minNum = subNum;
                }
            }
        }
        memo.put(n, minNum);
        return minNum;
    }
    public static List<Integer> getSmallerSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            squares.add(i * i);
        }
        return squares;
    }