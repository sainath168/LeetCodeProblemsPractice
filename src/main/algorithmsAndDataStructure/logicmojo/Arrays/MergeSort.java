package main.algorithmsAndDataStructure.logicmojo.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = new int[]{8, 4, 3, 12, 25, 6, 13, 10};
        mergeSort(input, input.length);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    static void mergeSort(int[] arr, int len) {

        if (len == 1) {
            return;
        }

        int mid = len / 2;

        int[] first = new int[mid];
        for (int i = 0; i < mid; i++) {
            //System.out.println(i);
            first[i] = arr[i];
        }
        int[] second = new int[len - mid];
        for (int j = mid; j < len; j++) {
            //System.out.println(j);
            second[j - mid] = arr[j];
        }

        mergeSort(first, first.length);
        mergeSort(second, second.length);
        merge(first, second, arr);
    }

    static void merge(int[] arr1, int[] arr2, int[] input) {

        int arr1_len = arr1.length;
        int arr2_len = arr2.length;

        int i = 0, j = 0, k = 0;
        while (i < arr1_len && j < arr2_len) {
            if (arr1[i] < arr2[j]) {
                input[k] = arr1[i];
                i++;
            } else {
                input[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1_len) {
            input[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2_len) {
            input[k] = arr2[j];
            j++;
            k++;
        }

    }
}
