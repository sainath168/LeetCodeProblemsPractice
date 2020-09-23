package main.algorithmsAndDataStructure.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 *
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class BringAnagramsTogether {

    public static void main(String[] args) {

    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> mapOfAnagrams = new HashMap<>();

        /**
         *
         * Loop through all the String Array
         *  - for each String, sort the characters inside it
         *  this can be done by first converting the String to char array and then sort the array elements
         *
         * - then follow below theme...
         *
         * Theme : sort any word should come to same stage if they contain same set of characters.
         * Ex: "ate" and "eat" string after sorting looks same "aet"
         *
         * and that sorted string will be the key in the above map and the respective String
         * will be added to that value list...
         *
         * Finally add all the values in the map to a List and return it
         * ===> list.addAll(map.values());
         *
         */

        return null;
    }

}
