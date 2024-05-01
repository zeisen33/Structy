package MixedRecall;

class Source {
    public static boolean detectDictionary(List<String> dictionary, String alphabet) {
        for (int j = 0; j < dictionary.size() - 1; j++) {
            if (!lexicalOrder(dictionary.get(j), dictionary.get(j + 1), alphabet)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean lexicalOrder(String word1, String word2, String alphabet) {
        for (int i = 0; i < Math.max(word1.length(), word2.length()); i++) {
            char char1 = i < word1.length() ? word1.charAt(i) : '\0';
            char char2 = i < word2.length() ? word2.charAt(i) : '\0';
            int idx1 = alphabet.indexOf(char1);
            int idx2 = alphabet.indexOf(char2);
            if (idx1 < idx2) {
                return true;
            } else if (idx1 > idx2) {
                return false;
            }
        }
        return true;
    }
