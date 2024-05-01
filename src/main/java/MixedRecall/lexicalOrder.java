package MixedRecall;

class Source {
    public static boolean lexicalOrder(String word1, String word2, String alphabet) {
        HashMap<Character, Integer> dict = new HashMap<>();

        for (int i = 0; i < alphabet.length(); i++) {
            char ch = alphabet.charAt(i);
            dict.put(ch, i);
        }

        char char1 = word1.charAt(0);
        char char2 = word2.charAt(0);
        int idx1;
        int idx2;

        int j = 0;
        while (j < word1.length() && j < word2.length()) {
            char1 = word1.charAt(j);
            char2 = word2.charAt(j);
            idx1 = dict.get(char1);
            idx2 = dict.get(char2);
            if (idx1 < idx2) {
                return true;
            } else if (idx1 > idx2) {
                return false;
            }
            j++;
        }

        if (j >= word1.length()) {
            return true;
        }
        // char1 = word1.charAt(word1.length() - 1);
        // while (j < word2.length()) {
        //   char2 = word2.charAt(j);
        //   j++;
        // }
        // idx1 = dict.get(char1);
        // idx2 = dict.get(char2);
        // if (idx1 < idx2) {
        //   return true;
        // } else if (idx1 > idx2) {
        //   return false;
        // }
        // }

        if (j >= word2.length()) {
            return false;
        }
        //   char2 = word2.charAt(word2.length() - 1);
        //   while (j < word1.length()) {
        //     char1 = word1.charAt(j);
        //     j++;
        //   }
        //   idx1 = dict.get(char1);
        //   idx2 = dict.get(char2);
        //   if (idx1 < idx2) {
        //     return true;
        //   } else if (idx1 > idx2) {
        //     return false;
        //   }
        // }

        return true;
    }
