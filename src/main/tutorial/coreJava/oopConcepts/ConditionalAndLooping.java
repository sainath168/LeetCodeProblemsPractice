package main.tutorial.coreJava.oopConcepts;

public class ConditionalAndLooping {
    public static void main(String[] args) {

        //if  else if   else
        //  ---- simple to understand

        // switch statements
        //  --- you need to remember that "double" data type is NOT supported
        //  --- also about break statement and default case

        //why loop - simple ex, if you want to print hello 5 times, it is very bad to write 5 print hello stmts
        // so use some loop and put condition <= 5

        int i = 1;

        while (i <= 5) {
            System.out.println("hello in while");
            i++; // if you don't put this it will always be 1 and goto infinite loop
        }


        //Note: i was already 5 due to above code but still below do while is executed and prints once
        do {
            System.out.println("hello in do while");
            i++; // if you don't put this it will always be 1 and goto infinite loop
        } while (i <= 5);


        for (int j = 1; j <= 5; j++) {
            System.out.println("hello in for");
        }

        /*
        // you can separate initialization and increment/decrement and modify as for stmt as per your needs
        int z = 1;
        for (; z <= 5;) {
            System.out.println("hello");
            z++;
        }*/

        /**
         * Print below stars using for loop
         *              * * * *
         *              * * * *
         *              * * * *
         *              * * * *
         */
        for (int star = 1; star <= 4; star++) {
            for (int star2 = 1; star2 <= 4; star2++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        /**
         * Print below pattern using for loop
         *              1
         *              1 2
         *              1 2 3
         *              1 2 3 4
         */
        for (int row = 1; row <= 4; row++) {
            for (int digit = 1; digit <= row; digit++) {
                System.out.print(digit + " ");
            }
            System.out.println();
        }

        /**
         * Print below pattern using for loop
         *              A
         *              A B
         *              A B C
         *              A B C D
         */
        for (int row = 1; row <= 4; row++) {
            for (int digit = 1; digit <= row; digit++) {
                int asciiCharacter = 64 + digit; // 65 = A, 66 = B, 67 = C so on...
                System.out.print((char) asciiCharacter + " ");
            }
            System.out.println();
        }

        /**
         * Print below pattern using for loop
         *              $ $ $ $
         *              $     $
         *              $     $
         *              $ $ $ $
         */
        int totalRows = 10;
        for (int row = 1; row <= totalRows; row++) {
            for (int digit = 1; digit <= totalRows; digit++) {
                //rows other than first and last rows, print $ only in first and last iteration
                if (row != 1 && row != totalRows) {
                    String str = (digit == 1 || digit == totalRows) ? "$ " : "  ";
                    System.out.print(str);
                } else {
                    System.out.print("$ ");
                }
            }
            System.out.println();
        }


        /**
         * We must have array utility methods but below logic to take array values and print comma
         * separated values
         * NOTE : main task here to don't add comma to last item
         */
        int[] array = {1, 2, 3};
        StringBuilder builder = new StringBuilder();

        for (int value : array) {
            //instead of printing or appending value first and later figuring out last iteration in the loop
            //to skip adding "," ------- below code is good because you append "," and then value but you
            //skip the first iteration which is always easy to figure out (in while/do-while/for/foreach)
            if (builder.length() != 0) {
                builder.append(",");
            }
            builder.append(value);
        }
        System.out.println(builder);

    }
}
