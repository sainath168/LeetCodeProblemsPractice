package main.tutorial.coreJava.coreConcepts.strings;

import java.util.HashMap;
import java.util.Map;

public class MaxOccurringCharacters {

    static final String searchTerm = "sainath";

    static char getMaxOccurredCharacterInString(String str) {

        char[] convertedToChar = str.toCharArray();

        Map<Character, Integer> mapOfCharWithCount = new HashMap<>();

        for (char c : convertedToChar) {
            if (mapOfCharWithCount.containsKey(c)) {
                mapOfCharWithCount.put(c, mapOfCharWithCount.get(c) + 1);
            } else {
                mapOfCharWithCount.put(c, 1);
            }
        }

        int currentMax = 0;
        char result = ' '; // result will be a character which occurred more in a given string
         for (Map.Entry<Character, Integer> entry : mapOfCharWithCount.entrySet()) {
             if (entry.getValue() > currentMax) {
                 currentMax = entry.getValue();
                 result = entry.getKey();
             }
         }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(getMaxOccurredCharacterInString(searchTerm));

    }
}
