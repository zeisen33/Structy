package DynamicProgramming;

import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;

class Source {
    public static boolean canConcat(String s, List<String> words) {
        return canConcat(s, 0, words, new HashMap<SimpleEntry<String, Integer>, Boolean>());
    }
    public static boolean canConcat(String s, int idx, List<String> words, HashMap<SimpleEntry<String, Integer>, Boolean> memo) {
        if (idx >= s.length()) {
            return true;
        }
        for (String word : words) {
            int len = word.length();
            SimpleEntry<String, Integer> entry = new SimpleEntry<>(word, idx);
            if (memo.containsKey(entry)) {
                if (memo.get(entry)) {
                    return true;
                } else {
                    continue;
                }
            }
            // System.out.println(word);
            if (idx + len > s.length()) {
                memo.put(entry, false);
                continue;
            } else if (s.substring(idx, idx + len).equals(word)) {
                if (canConcat(s, idx + len, words, memo)) {
                    memo.put(entry, true);
                    return true;
                } else {
                    memo.put(entry, false);
                }
            }
        }
        return false;
    }
