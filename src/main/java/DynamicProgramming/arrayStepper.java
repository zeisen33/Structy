package DynamicProgramming;

import java.util.List;
import java.util.Stack;
import java.util.HashSet;


class Source {
    public static boolean arrayStepper(List<Integer> nums) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> memo = new HashSet<>();
        int lastIdx = nums.size() - 1;
        stack.push(0);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.println(current);
            if (current == lastIdx) {
                return true;
            }
            if (memo.contains(current)) {
                continue;
            }
            if (current > lastIdx) {
                continue;
            }
            for (int i = 1; i <= nums.get(current); i++) {
                stack.push(current + i);
            }
            memo.add(current);
        }
        return false;
    }