package DynamicProgramming;

import java.util.List;
import java.util.HashMap;

class Source {
    public static int quickestConcat(String s, List<String> words) {
        // System.out.println("--- " + Integer.MAX_VALUE);
        int res = quickestConcat(s, words, new HashMap<String, Integer>());
        // want to use infinity. Should use Double.POSITIVE_INFITY but this works too.
        // when we add 1 to Max_Value later, we don't want integer overflow, so we subtract 1 in preparation to add 1 without overflowing. Next time much easier to use Double.POSITIVE_INFITY which is actual infinity.
        if (res == Integer.MAX_VALUE - 1) {
            return -1;
        } else {
            return res;
        }
    }
    public static int quickestConcat(String s, List<String> words, HashMap<String, Integer> memo) {
        System.out.println(s);
        if (s.length() == 0) {
            return 0;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int min = Integer.MAX_VALUE - 1;
        for (String word : words) {
            if (s.startsWith(word)) {
                String subs = s.substring(word.length());
                System.out.println("subs" + subs + "\n");
                int res = 1 + quickestConcat(subs, words, memo);
                System.out.printf("res: %s%n", res);
                if (res < min) {
                    min = res;
                }
                System.out.printf("min: %s%n", min);
            }
        }
        memo.put(s, min);
        return min;
    }