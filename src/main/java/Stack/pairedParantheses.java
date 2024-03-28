package Stack;

import java.util.Stack;

class Source {
    public static boolean pairedParentheses(String str) {
        Stack<Character> stack = new Stack<>();

        for (char chrctr : str.toCharArray()) {
            if (chrctr == '(') {
                stack.push(')');
            }
            if (chrctr == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }