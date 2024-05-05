package MixedRecall;

import java.util.List;
import java.util.HashMap;


class Source {
    public static String safeCracking(List<List<Integer>> hints) {
        HashMap<Integer, Integer> numPreds = new HashMap<>();

        for (List<Integer> pair : hints) {
            numPreds.put(pair.get(0), 0);
        }
        for (List<Integer> pair : hints) {
            if (numPreds.containsKey(pair.get(1))) {
                numPreds.put(pair.get(1), numPreds.get(pair.get(1)) + 1);
            } else {
                numPreds.put(pair.get(1), 1);
            }
        }

        String output = "";

        while (numPreds.values().contains(0)) {
            for (Integer key : numPreds.keySet()) {
                if (numPreds.get(key) == 0) {
                    output = output + String.valueOf(key);
                    numPreds.put(key, -1);
                    for (List<Integer> pair : hints) {
                        if (pair.get(0) == key) {
                            numPreds.put(pair.get(1), numPreds.get(pair.get(1)) - 1);
                        }
                    }
                }
            }
        }

        return output;
    }
