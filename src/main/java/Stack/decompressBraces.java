package Stack;

import java.util.Stack;
import java.util.List;

class Source {
    public static String decompressBraces(String str) {
        String digits = "0123456789";

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '}') {
                String subs = "";
                while (!digits.contains(stack.peek())) {
                    subs = stack.pop() + subs;
                }
                int repeats = Integer.valueOf(stack.pop());

                stack.push(subs.repeat(repeats));
            }
            if (ch != '{' && ch != '}') {
                stack.push(String.valueOf(ch));
            }
        }

        return String.join("", stack);
    }