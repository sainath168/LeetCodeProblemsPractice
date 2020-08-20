package main.algorithmsAndDataStructure.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class TwoSumProblem {

    public static void main(String[] args) {
        int[] nums = {2, 11, 15, 7};
        int target = 9;

        int[] result = new int[2];


        /**
         *
         * we can use List but looking up value here (in this case using indexOf())
         * will go through the array again, which leads to O(n2))
         *
        List<Integer> numsAsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (Integer a : numsAsList) {
            int valueToFindOut = target - a;
            if (numsAsList.contains(valueToFindOut)) {
                result[0] = numsAsList.indexOf(a);
                result[1] = numsAsList.indexOf(valueToFindOut);
                break;
            }

        }
         */


        /**
         * Map loop is faster and takes constant time ---> O(1)
         * so overall this can be achieved in one loop along with hashmap usage ---> total O(n)
         */

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int valueToFindOut = target - nums[i];
            if (numMap.containsKey(valueToFindOut)) {
                result[0] = i;
                result[1] = numMap.get(valueToFindOut);
            } else {
                numMap.put(nums[i], i); //put value as key and index as value...we need indices here
            }

        }

        System.out.println(result[0] + ", " + result[1]);

    }
}
