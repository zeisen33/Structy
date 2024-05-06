package MixedRecall;

class Source {
    public static String tokenReplace(String s, Map<String, String> tokens) {
        String newStr = "";

        int i = 0;
        int j = 0;
        Boolean open = false;

        while (j < s.length()) {
            System.out.println(newStr);
            // System.out.println(j);
            char ch = s.charAt(j);
            if (ch != '$' && !open) {
                newStr = newStr + ch;
                j++;
            } else {
                i = j;
                // System.out.println(j);
                String subs = s.substring(i + 1);
                // System.out.println(subs);
                j = s.substring(i + 1).indexOf("$");
                // System.out.println(j);
                int k = i + j + 2;
                newStr = newStr + tokens.get(s.substring(i, k));
                i = k;
                j = k;
                // System.out.println(i);
            }
            System.out.println(j);
        }


        return newStr;
    }