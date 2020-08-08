package main.algorithmsAndDataStructure.sortingAlgo;

/**
 * Selection Sort
 * find the min number by iterating through all the items and swap with the initial indices.
 * first figured out min number goes to [0]
 * second figured out min number goes to [1]
 * and so on...
 *
 * Same like you hold playing cards from zigzag positions and then you
 * arrange them like this =====>  A, 2, 3 ... 10, J, Q, K
 * Here, when you look at "A" you put it in first position and then search for 2 and so on..
 */
public class SelectionSortExample {
    public static void main(String[] args) {
        int[] data = {7, 2, 4, 1, 5, 3};

        int totalIterations = 0;
        for (int i = 0; i < data.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < data.length; j++) {
                totalIterations++;
                if (data[j] < data[minPos]) {
                    minPos = j;
                }
            }
            int temp = data[i];
            data[i] = data[minPos];
            data[minPos] = temp;

        }

        for (int d : data) {
            System.out.println(d);
        }

        System.out.println("Total iterations " + totalIterations);

    }
}
