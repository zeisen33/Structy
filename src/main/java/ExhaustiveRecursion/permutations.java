package ExhaustiveRecursion;

import java.util.List;
import java.util.ArrayList;

class Source {
    public static List<List<String>> permutations(List<String> elements) {
        if (elements.size() == 0) {
            return List.of(List.of());
        }

        List<List<String>> allPerms = new ArrayList<>();

        String firstEl = elements.get(0);

        List<List<String>> subPerms = permutations(elements.subList(1, elements.size()));

        for (List<String> subPerm : subPerms) {
            for (int i = 0; i <= subPerm.size(); i++) {
                List<String> newPerm = new ArrayList<>();
                List<String> left = subPerm.subList(0, i);
                List<String> right = subPerm.subList(i, subPerm.size());
                newPerm.addAll(left);
                newPerm.add(firstEl);
                newPerm.addAll(right);
                allPerms.add(newPerm);
            }
        }
        return allPerms;
    }