package DynamicProgramming;

import java.util.List;
import java.util.HashMap;

class Source {
    public static boolean sumPossible(int amount, List<Integer> numbers) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        return sumPossible(amount, map, numbers);
    }
    public static boolean sumPossible(Integer amount, HashMap<Integer, Boolean> map, List<Integer> numbers) {
        if (amount == 0) {
            return true;
        }
        if (amount < 0) {
            return false;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        for (Integer num : numbers) {
            if (sumPossible(amount - num, map, numbers)) {
                map.put(amount, true);
                return true;
            }
        }
        map.put(amount, false);
        return false;
    }