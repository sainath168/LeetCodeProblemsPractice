package tutorial.coreJava.oopConcepts;

public class ArraysExample {
    public static void main(String[] args) {

        // declaration of array
        // this can store 2 elements/values at index 0 and 1
        int[] intArray = new int[2];
        intArray[1] = 1;
        System.out.println(intArray[0]); // no value set at 0 index so prints default value of int i.e., 0


        // another way of declaring arrays
        // based on the no. of elements/values in the brackets decides the size of the array
        int[] intArray2 = {1, 2};

        // Arrays can be used to store any value (primitive datatype value or objects)
        // but all the values in the array should be of same type
        Student s1 = new Student();

        // you can define the array with size and then assign values to each index
        Student[] sArray = new Student[5];
        sArray[1] = new Student();
        sArray[2] = new Student();
        sArray[3] = new Student();

        // you can define the array and values at the same time here
        // (same like primitive usecase above based on the no. of elements in the brackets decides the size of the array)
        Student[] sArray2 = {new Student(), new Student()};

        // you can first create variables (with values) and then define the array
        Student[] sArray3 = {s1};

        // accessing any element outside the range will throw ArrayIndexOutOfBoundsException exception
        //System.out.println(intArray2[3]);


        System.out.println("--------------");
        /*** TwoDimentionalArray ***/


        TwoDimentionalArray td = new TwoDimentionalArray();

        // we have declared 2D array with equal number of rows and columns
        // in order to print all the values by looping through all the rows / columns

        //for looping through rows
        for (int i = 0; i < td.doubleArray.length; i++) {
            //for looping through columns...here, of course, columns = no. of elements in the row array
            for (int j=0; j < td.doubleArray[i].length; j++) {
                System.out.print(td.doubleArray[i][j]);
            }
            System.out.println();
        }

        System.out.println("--------------");

        //same thing can be done using enhanced for loop (foreach)
        for (int[] a : td.doubleArray) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }

    }
}

class Student {

}

class TwoDimentionalArray {

    // SIMPLE TO REMEMBER --- it is an Array of Array's and the format: {{},{},{},{}}

    int[][] doubleArray = {{1,2,3}, {4,5,6}, {7,8,9}};

    //again you can have separate array variables which can be used to define double array

    int[] a = {1, 2, 3};
    int[] b = {4, 5, 6};
    int[] c = {7, 8, 9};

    int[][] doubleArray2 = {a, b, c};

    int getSecondElementFromFirstRow() {
        return doubleArray[0][1];
    }


}
