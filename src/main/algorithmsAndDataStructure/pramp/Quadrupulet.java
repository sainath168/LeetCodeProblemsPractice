package main.algorithmsAndDataStructure.pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quadrupulet {

    static int[] findArrayQuadruplet(int[] arr, int s) {
        //for maintaining solutions
        int[] sol = {};

        int lastIndexValueInSolution = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 3; i++) {
            // i = 0 to length - 1
            // if [i] < sum
            for (int j = i + 1; j < arr.length - 2; j++) {
                // j = 0 to length - 1
                for (int z = j + 1; z < arr.length - 1; z++) {
                    // target = sum - [i] + [j]
                    if ((s - (arr[i] + arr[j])) == (arr[z] + arr[z+1])) {
                        if ((z+1) < lastIndexValueInSolution ) {
                            sol = new int[4];
                            //add to solutions
                            sol[0] = arr[i];
                            sol[1] = arr[j];
                            sol[2] = arr[z];
                            sol[3] = arr[z+1];
                            lastIndexValueInSolution = z + 1;
                        }
                    }
                }
            }
        }

        Arrays.sort(sol);
        return sol;
    }

    public static void main(String[] args) {

        int[] result = findArrayQuadruplet(new int[] {2, 7, 4, 0, 9, 5, 1, 3}, 20);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
