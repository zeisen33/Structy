package DynamicProgramming;

import java.util.List;
import java.util.HashMap;

class Source {
    public static int quickestConcat(String s, List<String> words) {
        return quickestConcat(s, words, new HashMap<String, Integer>());
    }
    public static int quickestConcat(String s, List<String> words, HashMap<String, Integer> memo) {
        System.out.println(s);
        if (s.length() == 0) {
            return 0;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int min = Integer.MAX_VALUE;
        for (String word : words) {
            if (s.startsWith(word)) {
                int res = 1 + quickestConcat(s.substring(word.length()), words, memo);
                System.out.println(res);
                if (res < min) {
                    min = res;
                }
            }
        }
        memo.put(s, min);
        return min;
    }
