package algorithmsAndDataStructure.logicmojo.Arrays;

import java.util.Arrays;

public class SortArrayWithThreeNumbers {

    /**
     * Sort an array only containing 0s, 1s and 2s
     * Given input here is something like this - {2, 1, 1, 0, 2, 2, 0, 0, 1, 1, 1}
     */

    // whenever we have predefined declaration of array and array size is less
    // then we can consider counting sort
    // counting sort = 1. Traverse thru array and count each value how many time it is repeated
    //                 2. Traverse thru array again and place the values in new array based on the number of times it is present in the array


    // But what if we want to do this sort in one traverse of loop then we can apply below algorithm
    /**
     * So the concept is to
     * - Arrange all 0's on left and 2's at the end and then ofcourse all 1's will be in middle
     *
     * So, for that we can have three pointer variables LOW, MID and HIGH
     *
     * And whenever you find the target elements then sort the values and change the pointers like below,
     *
     * LOW and MID will point to first index in the array
     * HIGH at the end of the array
     *
     * if array[MID] = 2, then swap(array[MID], array[HIGH])  and  HIGH--  (so here after HIGH whatever the indexes are present they are good and we don't have to care them)
     * if array[MID] = 0, then swap(array[MID], array[LOW]) and LOW++ and MID++   (here indexes before LOW are good and before MID we have already taken care)
     * if array[MID] = 1, then don't swap and just go to next index by doing MID++
     *
     * we need to do this until MID cross HIGH index position i.e (until MID <= HIGH)
     */

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 0, 2, 2, 0, 1, 1, 1};

        //LOW, MID will point to index 0 in the beginning
        int LOW = 0, MID = 0;
        //HIGH points to end of the array in the beginning
        int HIGH = arr.length - 1;

        while (MID <= HIGH) {
            if (arr[MID] == 2) {
                //swap MID and HIGH
                int mid = arr[MID];
                arr[MID] = arr[HIGH];
                arr[HIGH] = mid;
                //decrement HIGH
                HIGH--;
            } else if (arr[MID] == 0) {
                //swap MID and LOW
                int low = arr[LOW];
                arr[LOW] = arr[MID];
                arr[MID] = low;
                //increment LOW and MID
                LOW++;
                MID++;
            } else {
                //this case comes when it is 1
                //just increment MID
                MID++;
            }

        }

        System.out.println(Arrays.toString(arr));

    }

}
