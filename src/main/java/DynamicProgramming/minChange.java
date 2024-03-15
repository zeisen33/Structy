package DynamicProgramming;

import java.util.List;
import java.util.HashMap;

class Source {
    public static int minChange(int amount, List<Integer> coins) {
        HashMap<Integer, Integer> map = new HashMap<>();

        return minChange(amount, coins, map);
    }
    public static int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> map) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int min = -1;
        for (Integer coin : coins) {
            int res = minChange(amount - coin, coins, map);
            if (res != -1) {
                if (res + 1 < min || min == -1) {
                    min = res + 1;
                }
            }
        }
        map.put(amount, min);
        return min;
    }