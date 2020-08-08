package main.algorithmsAndDataStructure.problemSolving;

import java.util.*;
/**
 * Given an array, find the integer that appears an odd number of times.
 *
 * There will always be only one integer that appears an odd number of times.
 */
public class FindTheOddInt {
    public static int findIt(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("Array doesn't contain any integers");
        }
        //Algo 1:
        //have a map with each integer as KEY and occurences as VALUES
        //next, figure out the odd number in list of values and then return the key of it



        //Algo 2:
        // sort the array
        // you can loop through the array items by checking current and next,
        // and increment the counter if they both are equal
        // if current and next are not equal and counter is odd, return (RESULT)
        // if not, continue;
        int result = 0;
        if (a.length == 1) {
            return a[0];
        } else {
            Arrays.sort(a);
            int counter = 1;
            for (int i = 0; i < a.length - 1; i++) {
                int current = a[i];
                int next = a[i+1];
                if (current == next) {
                    counter += 1;
                } else {
                    if (counter % 2 == 1) {
                        return result;
                    } else {
                        counter = 1;
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = {-1, -2, 3, -1, -2, 4, 4, -5, -5};
        //System.out.println(findIt(a));

        int odd=0;
        for(int i=0; i<a.length; i++) {
            odd = odd^a[i];
        }
        System.out.println(odd);
    }
}
