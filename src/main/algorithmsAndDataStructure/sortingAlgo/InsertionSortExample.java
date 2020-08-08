package main.algorithmsAndDataStructure.sortingAlgo;

public class InsertionSortExample {
    public static void main(String[] args) {
        int[] data = {7, 2, 4, 1, 5, 3};

        int totalIterations = 0;
        /*for (int i = 1; i < data.length; i++) {
            int value = data[i];
            for (int j = 1; j <= i; j++) {
                if (data[j - 1] > value) {
                    totalIterations++;
                    //swap [j] with [value]
                    int temp = data[j - 1];
                    data[j - 1] = value;
                    data[i] = temp;
                    value = data[i];
                }
            }
        }*/

        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int hole = i;
            while (hole > 0 && data[hole - 1] > value) {
                totalIterations++;
                data[hole] = data[hole - 1];
                hole = hole - 1;
            }
            data[hole] = value;
        }

        /*for (int i = 0; i < data.length; i++) {
            int j = i;
            while (j>0 && data[j-1] > data[j]) {
                totalIterations++;
                int temp = data[j-1];
                data[j-1] = data[j];
                data[j] = temp;
                j = j - 1;
            }
        }*/

        for (int d : data) {
            System.out.println(d);
        }
        System.out.println("Total iterations: " + totalIterations);

    }
}
