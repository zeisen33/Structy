package DynamicProgramming;

import java.util.List;
import java.util.HashMap;

class Source {
    public static int nonAdjacentSum(List<Integer> nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return nonAdjacentSum(nums, memo, 0);
    }
    public static int nonAdjacentSum(List<Integer> nums, HashMap<Integer, Integer> memo, Integer idx) {
        if (idx == nums.size() - 1) {
            return Math.max(nums.get(idx), 0);
        }
        if (idx == nums.size() - 2) {
            int max = Math.max(nums.get(idx), nums.get(idx + 1));
            return Math.max(max, 0);
        }
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        int withCurr = nums.get(idx) + nonAdjacentSum(nums, memo, idx + 2);
        int withoutCurr = nonAdjacentSum(nums, memo, idx + 1);
        int max = Math.max(withCurr, withoutCurr);

        memo.put(idx, max);
        return max;
    }