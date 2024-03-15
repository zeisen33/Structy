package DynamicProgramming;

import java.util.List;
import java.util.HashMap;

class Source {
    public static int countingChange(int amount, List<Integer> coins) {
        return countingChange(amount, coins, new HashMap<>(), 0);
    }
    public static int countingChange(int amount, List<Integer> coins, HashMap<List<Integer>, Integer> memo, int coinIdx) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (coinIdx >= coins.size()) {
            return 0;
        }
        if (memo.containsKey(List.of(amount, coinIdx))) {
            return memo.get(List.of(amount, coinIdx));
        }
        int val = coins.get(coinIdx);
        int count = 0;
        for (int i = 0; i <= amount / val; i++) {
            // if (coinIdx >= coins.size()) {
            //   coinIdx = 0;
            //   continue;
            // }
            count += countingChange(amount - (i * val), coins, memo, coinIdx + 1);
        }
        memo.put(List.of(amount, coinIdx), count);
        return count;
    }
