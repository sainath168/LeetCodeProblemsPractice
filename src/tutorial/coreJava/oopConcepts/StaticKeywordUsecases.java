package tutorial.coreJava.oopConcepts;

public class StaticKeywordUsecases {

    static void printSomeStaticContent() {
        System.out.println("This is from static method");
    }
    /**
     * Same applicable to static here for main method
     * this will be loaded when classes are loaded and no object is required to load this to memory
     */
    public static void main(String[] args) {
        printSomeStaticContent();

        SubClass obj = new SubClass();

        SubClass obj2 = new SubClass();
        obj2.a = 6;
        obj2.b = 7;
        //obj2.c = 8;

        // print first object values
        // don't expect that it will print 1 2 3
        // as "c" variable is static, it will be in class loader memory and not in object in heap
        // so it will contain one static value, and same value can be accessed by all the objects
        // OR using ClassName ---> in this case, SubClass.c
        System.out.println(obj.a + " " + obj.b + " " + obj.c);

        // print second object values
        // everything as explained above and also note that instance variables should be accessed with
        // that particular instance/object of the class, but static variables can/should be accessed using classname
        System.out.println(obj2.a + " " + obj2.b + " " + obj2.c);

        // can be accessed with className also, this is recommended for accessing static variables
        System.out.println(SubClass.c);
    }
}

class SubClass {

    //instance variables
    int a;
    int b;
    // static variables
    // note: you can access this variables by any objects of this class but prefer using className instead
    // because it will always have one value, which is last updated / assigned value
    static int c;

    static {
        c = 10;
    }

    //lets use constructor to initialize the variables declared above to undersand more about static block {}
    SubClass() {
        a = 1;
        b = 3;
        /**
         * we can initialize the static variables also but what is the use of doing this for
         * for every object, so that's why we have static blocks where we can declare
         * and also that static block will be EXECUTED ONCE
         */
        //c = 10;
    }


}
