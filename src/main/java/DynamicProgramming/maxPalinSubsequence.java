package DynamicProgramming;

import java.util.HashMap;
import java.util.List;

class Source {
    public static int maxPalinSubsequence(String str) {
        return maxPalinSubsequence(str, new HashMap<List<Integer>, Integer>(), 0, str.length());
    }
    public static int maxPalinSubsequence(String str, HashMap<List<Integer>, Integer> memo, int start, int end) {
        String subs = str.substring(start, end);
        if (subs.length() == 0) {
            memo.put(List.of(start, end), 0);
            return 0;
        }
        if (subs.length() == 1) {
            memo.put(List.of(start, end), 1);
            return 1;
        }
        if (memo.containsKey(List.of(start, end))) {
            return memo.get(List.of(start, end));
        }
        int max = 0;
        if (subs.charAt(0) == subs.charAt(subs.length() - 1)) {
            max = 2 + maxPalinSubsequence(str, memo, start + 1, end - 1);
            memo.put(List.of(start, end), max);
        } else {

            max = Math.max(maxPalinSubsequence(str, memo, start, end - 1), maxPalinSubsequence(str, memo, start + 1, end));
            memo.put(List.of(start, end), max);
        }
        return max;
    }