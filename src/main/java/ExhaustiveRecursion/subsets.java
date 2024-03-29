package ExhaustiveRecursion;

import java.util.List;
import java.util.ArrayList;

class Source {
    public static List<List<String>> subsets(List<String> elements) {
        if (elements.isEmpty()) {
            return List.of(List.of());
        }

        List<List<String>> finalList = new ArrayList<List<String>>();
        String ele = elements.get(0);
        List<String> otherEls = elements.subList(1, elements.size());
        List<List<String>> restOfSubsets = subsets(otherEls);
        // now need to copy restOfSubsets, add el to all the copies, and add restOfSubsets and restOfSubsetsWithEl to finalList
        List<String> restOfSubsetsWithEl = new ArrayList<>();
        for (List<String> subset : restOfSubsets) {
            finalList.add(subset);
            ArrayList<String> copyWithEl = new ArrayList<>(subset);
            copyWithEl.add(ele);
            finalList.add(copyWithEl);
        }