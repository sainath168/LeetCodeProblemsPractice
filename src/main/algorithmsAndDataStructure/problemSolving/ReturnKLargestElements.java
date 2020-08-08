package main.algorithmsAndDataStructure.problemSolving;

import java.util.Arrays;

public class ReturnKLargestElements {
    public static void main(String[] args) {
        int[] data = {1, 23, 12, 9, 30, 2, 50};   // o/p: {50, 30, 23} if k=3

        for (int i : returnKLargestElements(data,3)) {
            System.out.println(i);
        }

    }


    private static int[] returnKLargestElements(int[] data, int k) {

        if (k > 0) {
            /**
             * Using Arrays in-built method
             * (Arrays.sort does quick sort internally but it sorts all n elements in
             * the array but we need only last k (in this case, 3) elements,
             * any better solution than this would be good...)

            Arrays.sort(data);
            int l = data.length - 1;
            return new int[]{data[l], data[l-1], data[l-2]};
             */


            /**
             * Can we do same quick sort until k elements ?
             * and is this the best solution ?
             */






        }

        return new int[]{};
    }


}
