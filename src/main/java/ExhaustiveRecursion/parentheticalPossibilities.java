package ExhaustiveRecursion;

import java.util.List;
import java.util.ArrayList;

class Source {
    public static List<String> parentheticalPossibilities(String s) {
        if (s.indexOf('(') == -1) {
            return List.of(s);
        }

        List<String> finalList = new ArrayList<>();

        int openIdx = s.indexOf('(');
        int closeIdx = s.indexOf(')');

        List<String> rest = parentheticalPossibilities(s.substring(closeIdx + 1));

        String start = s.substring(0, openIdx);

        for (int i = openIdx + 1; i < closeIdx; i++) {
            List<String> copyList = rest;
            for (String el : copyList) {
                el = start + s.charAt(i) + el;
                finalList.add(el);
            }

        }

        return finalList;
    }