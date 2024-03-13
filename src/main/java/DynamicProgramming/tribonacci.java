package DynamicProgramming;

import java.util.HashMap;

class Source {
    public static int tribonacci(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return tribonacci(n, map);
    }

    public static int tribonacci(int n, HashMap<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int res = tribonacci(n - 3, map) + tribonacci(n - 2, map) + tribonacci(n - 1, map);
        map.put(n, res);
        return res;
    }