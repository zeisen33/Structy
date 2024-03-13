package DynamicProgramming;

import java.util.HashMap;

class Source {
    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }

    public static int fib(int n, HashMap<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int res = fib(n - 1, map) + fib(n - 2, map);
        map.put(n, res);
        return res;
    }