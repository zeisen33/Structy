package ExhaustiveRecursion;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

class Source {
    public static List<String> substituteSynonyms(String sentence, Map<String, List<String>> synonyms) {
        List<String> words = Arrays.asList(sentence.split(" "));
        List<List<String>> sents = generate(words, synonyms);
        List<String> finalSents = new ArrayList<>();

        for (List<String> listWords : sents) {
            finalSents.add(String.join(" ", listWords));
        }

        return finalSents;
    }
    public static List<List<String>> generate(List<String> words, Map<String, List<String>> synonyms) {
        if (words.size() == 0) {
            return List.of(List.of());
        }

        List<List<String>> allLists = new ArrayList<>();

        String firstWord = words.get(0);
        List<List<String>> subLists = generate(words.subList(1, words.size()), synonyms);

        if (synonyms.containsKey(firstWord)) {
            for (String syn : synonyms.get(firstWord)) {
                for (List<String> subList : subLists) {
                    List<String> newList = new ArrayList<>();
                    newList.add(syn);
                    newList.addAll(subList);
                    allLists.add(newList);
                }
            }
        } else {
            for (List<String> subList : subLists) {
                List<String> newList = new ArrayList<>();
                newList.add(firstWord);
                newList.addAll(subList);
                allLists.add(newList);
            }

        }
        return allLists;
    }