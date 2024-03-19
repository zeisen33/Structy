package DynamicProgramming;

import java.util.HashMap;
import java.util.List;

class Source {
    public static int overlapSubsequence(String str1, String str2) {
        return overlapSubsequence(str1, str2, 0, 0, new HashMap<List<Integer>, Integer>());
    }

    public static int overlapSubsequence(String str1, String str2, int idx1, int idx2, HashMap<List<Integer>, Integer> memo) {
        String subs1 = str1.substring(idx1);
        String subs2 = str2.substring(idx2);
        if (memo.containsKey(List.of(idx1, idx2))) {
            return memo.get(List.of(idx1, idx2));
        }
        if (subs1.length() == 0 || subs2.length() == 0) {
            // memo.put(List.of(idx1, idx2), 0);
            return 0;
        }

        if (subs1.charAt(0) == subs2.charAt(0)) {
            int res = 1 + overlapSubsequence(str1, str2, idx1 + 1, idx2 + 1, memo);
            memo.put(List.of(idx1, idx2), res);
            return res;
        }
        int max = Math.max(overlapSubsequence(str1, str2, idx1 + 1, idx2, memo), overlapSubsequence(str1, str2, idx1, idx2 + 1, memo));
        memo.put(List.of(idx1, idx2), max);
        return max;
    }