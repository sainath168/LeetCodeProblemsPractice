package main.algorithmsAndDataStructure.problemSolving;

/**
 * Copied problem statement from online:
 *
 * Your task is to construct a building which will be a pile of n cubes. The cube at the bottom will have a volume of n^3, the cube above will have volume of (n-1)^3 and so on until the top which will have a volume of 1^3.
 * You are given the total volume m of the building. Being given m can you find the number n of cubes you will have to build?
 * The parameter of the function findNb (find_nb, find-nb, findNb) will be an integer m and you have to return the integer n such as n^3 + (n-1)^3 + ... + 1^3 = m if such a n exists or -1 if there is no such n.
 */
public class BuildAPileOfCubes {

    public static long findNum(long m) {

        // minimum number is (1 pow 3 = 1) so if m is below that then return -1
        if (m > 0 && m < Long.MAX_VALUE) {
            /**
             * Algo:
             *
             * (1 pow 3) = 1  ---> this will be the case, if input "m" is 1 (then result "n" = 1)
             * (2 pow 3) + (1 pow 3) = 9 ---> if input "m" is 9 (then result "n" = 2)
             * (3 pow 3) + (2 pow 3) + (1 pow 3) = 36 ---> if input "m" is 36 (then result "n" = 3)
             * (4 pow 3) + (3 pow 3) + (2 pow 3) + (1 pow 3) = 100 ---> if input "m" is 100 (then result "n" = 4)
             *
             *
             * Let's start with counter i = 1;
             * calculate m - (i pow 3), then if result is 0 then n = i
             *
             * Example, consider m = 9,
             * store m in some variable ---> result = 9
             * calculate result - (1 pow 3) = 8, then return i if result = 0, if not increment i
             * calculate result - (2 pow 3) = 0, then return i if result = 0, if not increment i
             *
             * continue this loop until result = 0, in any step if result < 0, then exit from loop and return -1
             */

            long result = m;
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                result = result - ((long) Math.pow(i, 3));
                if (result < 0) {
                    break;
                } else if (result == 0) {
                    return i;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BuildAPileOfCubes.findNum(4183059834009L));

        for (int i = 1; i < 10; i++) {
            System.out.println(i);
        }
    }

}
