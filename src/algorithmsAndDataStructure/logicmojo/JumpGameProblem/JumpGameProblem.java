package algorithmsAndDataStructure.logicmojo.JumpGameProblem;

public class JumpGameProblem {
    /**
     * Given an array of below values
     * 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9
     *
     * Now, problem statement is that to find out the min no. of jump's required to reach of the end of array
     * by using/considering the value at index position as the max number of jumping capability
     *
     * so, first jump is nothing but to jump on first index position and taking the value i.e. 1
     * and then, you can jump until current position + 1
     * and then, pointer goes to next index position i.e 3 which means you can consume that value and jump until next 3 positions
     * BUTTTTT, think that you may have greater numbers before you reach next 3 positions which you can take advantage of
     *
     */

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        //get the value at first index and set the jump value as 1
        int maxIndexValue = arr[0]; // this will hold the index value until we can go ahead
        int jump = 1; // this will hold the total number of occurences / the values we consumed in the array for jumping

        //we need one variable to keep track of the number of next iterations we should do

        for (int i = 0; i < arr.length; i++) {

        }
    }
}
