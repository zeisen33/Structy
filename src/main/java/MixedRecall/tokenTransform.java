package MixedRecall;

class Source {
    public static String tokenTransform(String s, Map<String, String> tokens) {
        String newString = "";
        int i = 0;
        int j = 1;

        while (i < s.length()) {
            // System.out.println(s);
            // System.out.println(i);

            char ch = s.charAt(i);
            // System.out.println(ch);

            if (ch != '$') {
                newString = newString + ch;
                i++;
                j = i + 1;
            } else {
                if (s.charAt(j) != '$') {
                    j++;
                } else {
                    String token = s.substring(i, j + 1);
                    newString = newString + tokenTransform(tokens.get(token), tokens);
                    i = j + 1;
                    j = i + 1;
                }
            }
        }

        return newString;
    }