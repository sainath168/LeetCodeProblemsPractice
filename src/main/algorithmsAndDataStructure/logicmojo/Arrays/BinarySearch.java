package main.algorithmsAndDataStructure.logicmojo.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] input = new int[]{3, 5, 6, 7, 12, 32, 43, 56, 58};
        int searchKey = 58;
        System.out.println(binarySearch(searchKey, input, 0, (input.length - 1)));
    }


    /**
     * Divide based on BST technique
     * @param arr
     * @return
     */
    static int binarySearch(int key, int[] arr, int low, int high) {


        int midPos = low + ((high - low) / 2);

        if (key == arr[midPos]) {
            return midPos;
        }

        if (key < arr[midPos]) {
            return binarySearch(key, arr, low, midPos - 1);
        } else {
            return binarySearch(key, arr, midPos + 1, high);
        }
    }
}
