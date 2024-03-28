package Stack;

import java.util.Stack;

class Source {
    public static boolean befittingBrackets(String str) {
        Stack<Character> opens = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char crctr = str.charAt(i);
            if (crctr == '(' || crctr == '{' || crctr == '[') {
                opens.push(crctr);
            } else {
                if (opens.isEmpty()) {
                    return false;
                }
                char popped = opens.pop();
                if (popped == '(' && crctr == ')') {
                    continue;
                } else if (popped == '{' && crctr == '}') {
                    continue;
                } else if (popped == '[' && crctr == ']') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return opens.isEmpty();
    }

    import java.util.HashMap;
import java.util.Stack;

    class Source {
        public static boolean befittingBrackets(String str) {
            HashMap<Character, Character> brackets = new HashMap<>();
            brackets.put('{', '}');
            brackets.put('(', ')');
            brackets.put('[', ']');
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (brackets.containsKey(ch)) {
                    stack.push(brackets.get(ch));
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (ch == stack.peek()) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
