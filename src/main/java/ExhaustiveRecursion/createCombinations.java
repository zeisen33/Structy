package ExhaustiveRecursion;

import java.util.List;
import java.util.ArrayList;

class Source {
    public static List<List<String>> createCombinations(List<String> items, int k) {
        if (k == 0) {
            return List.of(List.of());
        } else if (k > items.size()) {
            return List.of();
        }


        String firstEl = items.get(0);
        List<String> rest = items.subList(1, items.size());
        List<List<String>> finalItems = new ArrayList<>();

        for (List<String> combo : createCombinations(rest, k - 1)) {
            List<String> newCombo = new ArrayList<>(combo);
            newCombo.add(firstEl);
            finalItems.add(newCombo);
        }

        finalItems.addAll(createCombinations(rest, k));

        return finalItems;
    }