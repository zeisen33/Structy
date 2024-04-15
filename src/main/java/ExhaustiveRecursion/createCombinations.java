package ExhaustiveRecursion;

public static List<List<String>> createCombinations(List<String> items, int k) {
    if (items.size() == k) {
        return List.of(List.of());
    }


    String firstEl = items.get(0);
    List<String> rest = items.subList(1, items.size());
    List<List<String>> finalItems = new ArrayList<>();

    for (String remainingItem : rest) {
        List<List<String>> resWith = createCombinations(rest, k - 1);
        List<List<String>> resWithout = createCombinations(rest, k);

        for (List<String> res : resWith) {
            res.add(firstEl);
        }

        finalItems.addAll(resWith);

        finalItems.addAll(resWithout);

    }

    return finalItems;
}