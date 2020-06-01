package tutorial.coreJava.oopConcepts;

public class OuterAndInnerClass {

    public static void main(String[] args) {
        OuterClass obj = new OuterClass();
        obj.a = 1;

        //you need object of OuterClass to create inner class object unless the inner class is static
        OuterClass.InnerClassOne obj1 = obj.new InnerClassOne();
        obj1.b = 1;

        //as the InnerClassTwo is static you don't need object of OuterClass
        OuterClass.InnerClassTwo obj2 = new OuterClass.InnerClassTwo();
        obj2.c = 3;
        OuterClass.InnerClassTwo.d = 4;// or  obj2.d = 4;
    }

}


/**
 * Note: below there are 3 classes
 * but one OuterClass and 2 innerClass, so the class files generated will look something like this
 * OuterClass.class
 * OuterClass$InnerClassOne.class
 * OuterClass$InnerClassTwo.class
 */

class OuterClass {

    int a;

    class InnerClassOne {
        int b;
    }

    static class InnerClassTwo {
        int c;
        static int d;
    }
}
