package tutorial.coreJava.oopConcepts;

public class PolymorphismExample {

    /**
     *
     * Only two things to understand is about Method Overloading or Method Overriding
     * Method Overloading:
     *  Method signature is important - combination of the method name and the parameter list
     *  if method name is same then it will be called as overloaded method and what method
     *  is called / accessed it depends on the parameters (number/order of params and datatype plays major role)
     *
     */

    void methodOne(int param) {
        System.out.println("method with int param");
    }

    void methodOne(long param) {
        System.out.println("method with long param");
    }

    void methodOne(float param) {
        System.out.println("method with float param");
    }

    void methodOne(double param) {
        System.out.println("method with double param");
    }

    public static void main(String[] args) {
        PolymorphismExample obj = new PolymorphismExample();
        obj.methodOne(5);  // non-decimal values treated as int by default in java
        obj.methodOne(5.5);  // decimal values treated as double by default in java

        // put f explicitly to target float when float and double overloaded methods exist
        // if you don't have float overloaded method, then you either put f or not, all the
        // non-decimal values usecases targets to double overloaded method
        obj.methodOne(5.5f);
        obj.methodOne(5L); // put L explicitly when int and double overloaded methods exists
    }
}
