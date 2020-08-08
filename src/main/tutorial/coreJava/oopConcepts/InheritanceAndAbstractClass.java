package main.tutorial.coreJava.oopConcepts;

public class InheritanceAndAbstractClass {

    public static void main(String[] args) {
        // here we are creating object of class C which extends class B which indeed extends class A
        // so it will start executing the C constructor and first java implicitly call super()
        // that is constructor of B, which indeed calls super() again that triggers the constructor of A
        /*C obj = new C();*/

        //access the method overrided in class B
        /*B objOfB = new B();
        objOfB.show();*/

        /***
         * Run time polymorphism
         * and Dynamic Method Dispatch
         * ***/
        // you can create object of a children class and use parent class as a reference
        // but here using these references you can call methods that are in super class (the class that is being used as reference)
        A dynamicObj1 = new B();

        dynamicObj1.methodThatIsCalledByChildClasses();

        //you can still call the method that is not present in the parent class, but you have to
        // explicitly type cast to the object type
        ((B)dynamicObj1).anotherMethodThatCallSuperClassMethod();


        dynamicObj1.show(); // this will trigger show method in B, and this will be decided at runtime

        dynamicObj1 = new C();
        dynamicObj1.show(); //
    }

}

/**
 * Note: Java doesn't support multiple inheritance
 * that means, one class can extend only one class but not more ---> class C extends A, B (not possible)
 */

class A {

    public A() {
        System.out.println("in constructor A");
    }

    //constructor overloading
    public A(int i) {
        System.out.println("in constructor A - int ");
    }

    public void show() {
        System.out.println("in show method of A");
    }

    public void methodThatIsCalledByChildClasses() {
        //example to show that child classes can access members of parent class using super
        //---> when i say members it could be (variables or methods)
        System.out.println("method in A and can be called from child class using super");
    }

}

class B extends A {
    public B() {
        //super() ---> this is used to execute to super class constructor(s)
        // however, super() is included by java by default, but this will be used if you want to execute
        // parameterized constructor in another class constructor like below
        super(5);
        System.out.println("in constructor B");
    }


    /**
     * show() method here shows the example of method overriding
     * and annotation is optional but thins brings the contract of overriding
     */
    @Override
    public void show() {
        // you can use super keyword to access any members of parent class
        System.out.println("in show method of B");
    }

    public void anotherMethodThatCallSuperClassMethod() {
        super.methodThatIsCalledByChildClasses();
        System.out.println("method in object of type B");
    }
}

class C extends B {
    public C() {
        System.out.println("in constructor C");
    }

    @Override
    public void show() {
        //
    }
}

class D extends A {
    public D() {
        System.out.println("in constructor D");
    }
}

/**
 * we will need abstract class (mostly abstract methods we mean here)
 * usually to give us the idea what to do but not how to do
 * abstraction - showing you functionality by hiding the implementation
 *
 * - Code re-usability by declaring/implementing common methods in abstract class
 * - Contract with subclass
 *
 */
abstract class AbstractClass {

    public void methodWithImplementation() {

    }



}


