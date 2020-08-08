package main.algorithmsAndDataStructure.bigOnotation;


/**
 * Big O role in Time and Space complexity
 */


/**
 * First let's discuss about time complexity...
 * We use Big O notation to describe the performance of an program or algorithm
 */


public class BigOExamples {
    public static void main(String[] args) {

    }


    public void log(int[] numbers) {
        //O(1) - regardless of how big the data is, here it is going to fetch the first element
        //       using index 0, which takes always O(1) --> run time complexity of our program
        System.out.println(numbers[0]);
        System.out.println(numbers[0]);   // ---> including this it will be O(2), but you can simplify and still say O(1)

    }

    //Linear time : O(n)  : grows in linear time
    public void log2(int[] numbers, String[] names) {

        //O(n)  -  these are simple loops running in linear time, so it increases if data set is increased
        //         so we represent the linear number of times with 'n'
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        //even though you have another loop where you could say O(2n), you can simplify and say O(n)
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        //even though you have loop with another input with different size you could add to previous and say O(n + m),
        //you can still simplify and say O(n)
        for (int i = 0; i < names.length; i++) {
            System.out.println(numbers[i]);
        }

    }

    //Quadratic time : O(n ^ 2)   : grows more in some time
    public void log3(int[] numbers) {
        // O(n ^ 2)
        for (int first : numbers) {   // O(n)
            for (int second : numbers) {   // O(n)
                System.out.println(first + " " + second);
            }
        }

        //Note if we add another simple loop to this function which would O(n),
        //then we could say it takes O(n + n ^ 2)....but we can again simplify and say O(n ^ 2)
        for (int i : numbers) {
            System.out.println(i);
        }
    }

    //Quadratic time : O(n ^ 3) ... and so on examples for O(n ^ m)
    public void log4(int[] numbers) {
        // O(n ^ 3)
        for (int first : numbers) {   // O(n)
            for (int second : numbers) {   // O(n)
                for (int third : numbers) {   // O(n)
                    System.out.println(first + " " + second + " " + third);
                }
            }
        }
    }

    //Logarithmic time : O(log n)   :  slows down some time  (more scalable than linear or Quadratic)
    public void log5() {
        //example: apply BST algorithm for searching target in 1M items
    }


    //Exponential time : O(2 ^ n)  : is opposite to O(lon n)



    /**
     *
     * Now, Big O role in Space complexity
     *
     * In an ideal world, we think that our program should run much faster (TIME)
     * and with less amount of memory (SPACE)
     *
     * But, sometime mostly we should compromise one or the other,
     * for ex: in mobile device, an app should care space rather than time,
     * because only one user is going to use it always and mostly it will not deal with bunch of data at once....
     *
     */


    //Note: size of the input should not be considered to calculate the space complexity
    //      but you should consider the additional space that you are creating in the business logic / algorithm
    public void greet(String[] names) {

        //O(1) - here space taken by i variable will not be dependent on names dataset size
        for (int i = 0; i < names.length; i++) {
            System.out.println("Hi " + names[i]);
        }

        //O(n) - here namesCopy variable is direct proportion to size of the names dataset size
        String[] namesCopy = new String[names.length];
    }



}
