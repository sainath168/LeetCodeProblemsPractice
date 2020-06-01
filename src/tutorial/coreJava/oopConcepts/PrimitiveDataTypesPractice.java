package tutorial.coreJava.oopConcepts;

public class PrimitiveDataTypesPractice {
    public static void main(String[] args) {

        /**** Primitive Data Types ****/

        // usually value should be like 'A', but takes ASCII value in case any number mentioned
        char c = 66;

        // -128 to 127
        byte b = 123;

        // go for long if it is more than 4 bytes
        int i = 2;

        //you need to append f in the end...because for point values, default type is double
        float f = 3.4f;

        //you don't need to put d at the end because by default java considers point values as double
        double d = 3.3575;

        System.out.println(c);
        System.out.println(b);
        System.out.println(i);
        System.out.println(f);
        System.out.println(d);

        //implicit conversion ----
        double ic = 5;
        System.out.println(ic);
        //explicit conversion / type casting
        int tc = (int) 5.6;
        System.out.println(tc); // will print only 5


        /***** Arithmetic Operators (+  -  *  /  %  ++ --) *****/

        //you can have comma separated variables of same datatype
        int m = 4, n = 2;

        // int result = m+n
        // int result = m-n
        // int result = m*n
        // double result = (double)m/n    ----  note: division operation returns int value if you need decimal values then you need to cast to double
        // int result = m%n   -- remainder

        // also, m+n or m+=n is same

        System.out.println(m++); // result will still be 4, m will be returned first and post incremented
        System.out.println(++n); // result will be 3, n will be pre incremented and then returned



    }
}
