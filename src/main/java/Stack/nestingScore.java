package Stack;

import java.util.Stack;

class Source {
    public static int nestingScore(String str) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        // 0 0 2
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '[') {
                stack.push(0);
            } else {
                int popped = stack.pop();
                if (popped == 0) {
                    stack.push(stack.pop() + 1);
                } else {
                    stack.push(stack.pop() + 2 * popped);
                }
            }
        }
        return stack.pop();
    }