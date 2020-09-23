package main.algorithmsAndDataStructure.sortingAlgo;

public class MergeSortExample {
    public static void main(String[] args) {
        int[] arr = {3,1,2,5};
        mergeSort(arr);
        System.out.println(arr[0]);
    }


    private static void mergeSort(int[] input) {
        // mergeSort takes Divide and Conquer approach
        // First you divide the list into 2 halves
        // Continue doing it until you left with individual items where you can compare each other
        // Now merge them ===> you compare while merging (lesser values goes in front and greater goes back)
        // this goes back until all the halves are merged


        if (input.length < 2) {
            return;
        }

        int middle = input.length / 2;
        int[] left = new int[middle];
        int[] right = new int[input.length - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = input[i];
        }

        for (int i = middle; i < input.length; i++) {
            right[i - middle] = input[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(left, right, input);

    }

    private static void merge(int[] left, int[] right, int[] input) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                input[k] = left[i];
                i++;
                k++;
            } else {
                input[k] = right[j];
                j++;
                k++;
            }
        }

        while (i < left.length) {
            input[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            input[k] = right[j];
            j++;
            k++;
        }
    }


}
